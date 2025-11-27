package iscteiul.insta.demo1.ex1b.basic.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import iscteiul.insta.demo1.ex1b.basic.page.NotificationMessagesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationMessagesTest {

    private WebDriver driver;
    private NotificationMessagesPage notificationMessagesPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        notificationMessagesPage = new NotificationMessagesPage(driver);
        notificationMessagesPage.navigateTo();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testNotificationMessage() {
        notificationMessagesPage.clickLink();
        String message = notificationMessagesPage.getNotificationText();
        List<String> possibleMessages = Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action Unsuccessful");
        assertTrue(possibleMessages.contains(message), "Notification message is not one of the expected messages. Got: " + message);
    }
}

