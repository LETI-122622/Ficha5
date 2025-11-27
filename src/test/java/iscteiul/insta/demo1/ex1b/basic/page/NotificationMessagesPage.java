package iscteiul.insta.demo1.ex1b.basic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessagesPage {

    private final WebDriver driver;
    private final By clickHereLink = By.linkText("Click here");
    private final By notificationMessage = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://the-internet.herokuapp.com/notification_message");
    }

    public void clickLink() {
        driver.findElement(clickHereLink).click();
    }

    public String getNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage));
        // A mensagem de notificação inclui um '×' para fechar, que removemos para a asserção.
        return driver.findElement(notificationMessage).getText().replace("×", "").trim();
    }
}

