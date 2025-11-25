package iscteiul.insta.demo1.ex1b.complex.test;

import iscteiul.insta.demo1.ex1b.complex.page.FileUploadPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadPageTest {
    private WebDriver driver;
    private FileUploadPage fileUploadPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        fileUploadPage = new FileUploadPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void submitFileError() {
        fileUploadPage.submitButton.click();
        assertTrue(driver.getPageSource().contains("Internal Server Error"));
    }

    /*@Test
    public void uploadFileError() {
        fileUpload.uploadButton.click();
        fileUpload.submitButton.click();
        assertTrue(driver.getPageSource().contains("File Uploaded!"));
    }*/
}
