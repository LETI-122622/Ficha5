package iscteiul.insta.demo1.ex1b;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-link']")
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    @FindBy(css = ".ch2-deny-all-btn")
    public WebElement denyAllCookiesButton;

    public void closeCookies() {
        try {
            if (denyAllCookiesButton.isDisplayed()) {
                denyAllCookiesButton.click();
            }
        } catch (NoSuchElementException e) {
            // O banner não apareceu → segue normalmente
        }
    }


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}