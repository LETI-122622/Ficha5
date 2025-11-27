package iscteiul.insta.demo1.ex1b.basic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAuthPage {

    private final WebDriver driver;
    private final By successMessage = By.cssSelector("div.example p");

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        // The-internet.herokuapp.com uses "admin" for both username and password for basic auth.
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
}

