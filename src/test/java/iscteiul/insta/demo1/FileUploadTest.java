package iscteiul.insta.demo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest {
    private WebDriver driver;
    private FileUpload fileUpload;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        fileUpload = new FileUpload(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void submitFileError() {
        fileUpload.submitButton.click();
        assertTrue(driver.getPageSource().contains("Internal Server Error"));
    }

    /*@Test
    public void uploadFileError() {
        fileUpload.uploadButton.click();
        fileUpload.submitButton.click();
        assertTrue(driver.getPageSource().contains("File Uploaded!"));
    }*/
}
