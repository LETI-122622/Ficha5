package iscteiul.insta.demo1.ex2.selenide.database.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import iscteiul.insta.demo1.ex2.selenide.database.page.VaadinDataBaseExampleDemoPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MovieInfoTest {

    VaadinDataBaseExampleDemoPage mainViewPage = new VaadinDataBaseExampleDemoPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://vaadin-database-example.demo.vaadin.com/");
    }

    @Test
    public void testFindKnivesOutInGrid() {
        String movieToSelect = "Knives Out";
        mainViewPage.findMovieByTitle(movieToSelect).shouldBe(visible);
    }
}
