package iscteiul.insta.demo1.ex1b.basic.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import iscteiul.insta.demo1.ex1b.basic.page.BasicAuthPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicAuthTest {

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testBasicAuth() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        basicAuthPage.navigateTo();
        String message = basicAuthPage.getSuccessMessage();

        assertTrue(message.contains("Congratulations! You must have the proper credentials."),
                "A mensagem de sucesso não foi encontrada.");
    }
}

