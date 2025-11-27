package com.vaadin.database.movie.pages;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class VaadinDataBaseExampleDemoPage {

    // Elements in the movie details panel
    public SelenideElement title = $(".movie-details h3");
    public SelenideElement releaseDate = $(".movie-details p:nth-of-type(1)");
    public SelenideElement director = $(".movie-details p:nth-of-type(2)");
    public SelenideElement genres = $(".movie-details p:nth-of-type(3)");
    public SelenideElement rating = $(".movie-details p:nth-of-type(4)");
    public SelenideElement imdbLink = $(".movie-details a");

    // The grid component
    private final SelenideElement grid = $("vaadin-grid");
    // The cells within the grid
    private final ElementsCollection movieGridCells = $$("vaadin-grid-cell-content");

    /**
     * Clicks on a movie in the grid based on its title.
     * This method handles the virtual scrolling of the vaadin-grid.
     * @param movieTitle The title of the movie to click.
     */
    public void selectMovieByTitle(String movieTitle) {
        grid.shouldBe(Condition.visible);
        Selenide.executeJavaScript("arguments[0].scrollToIndex(0)", grid);
        Selenide.sleep(500);

        while (true) {
            SelenideElement movieElement = movieGridCells.findBy(Condition.text(movieTitle));
            if (movieElement.exists()) {
                movieElement.click();
                Selenide.sleep(500); // Wait for UI to update
                return;
            }

            Integer last = Selenide.executeJavaScript("return arguments[0].lastVisibleIndex", grid);
            Integer total = Selenide.executeJavaScript("return arguments[0].items.length", grid);

            if (last != null && total != null && last.equals(total - 1)) {
                throw new IllegalStateException("Element with text '" + movieTitle + "' not found in the grid after scrolling.");
            }

            if (last != null) {
                Selenide.executeJavaScript("arguments[0].scrollToIndex(arguments[1])", grid, last);
                Selenide.sleep(500);
            } else {
                throw new IllegalStateException("Could not determine the last visible index to scroll.");
            }
        }
    }

    public SelenideElement findMovieByTitle(String movieTitle) {
        grid.shouldBe(Condition.visible);
        // Scroll to the top of the grid before starting
        Selenide.executeJavaScript("arguments[0].scrollToIndex(0)", grid);
        Selenide.sleep(500); // Wait for the grid to render the initial items

        while (true) {
            // Find the movie element within the currently visible items
            SelenideElement movieElement = movieGridCells.findBy(Condition.text(movieTitle));
            if (movieElement.exists()) {
                return movieElement;
            }

            // Get the index of the last visible item and the total number of items
            Integer last = Selenide.executeJavaScript("return arguments[0].lastVisibleIndex", grid);
            Integer total = Selenide.executeJavaScript("return arguments[0].items.length", grid);

            // If we've reached the end of the grid and haven't found the movie, throw an error
            if (last != null && total != null && last.equals(total - 1)) {
                break; // Movie not found
            }

            // Scroll to the last visible index to load the next chunk of items
            if (last != null) {
                Selenide.executeJavaScript("arguments[0].scrollToIndex(arguments[1])", grid, last);
                Selenide.sleep(500); // Wait for new items to load
            } else {
                // If last is null, we can't scroll further, so break the loop
                break;
            }
        }
        return movieGridCells.findBy(Condition.text(movieTitle));
    }
}
