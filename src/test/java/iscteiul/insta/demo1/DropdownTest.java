package iscteiul.insta.demo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        dropdownPage = new DropdownPage(driver);
        dropdownPage.open();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void selectOptionFromDropdown() throws InterruptedException {
        dropdownPage.selectOption("Option 1");
        //Thread.sleep(2000);
        assertEquals("Option 1", dropdownPage.getSelectedOption());

        //Thread.sleep(2000);

        dropdownPage.selectOption("Option 2");
        //Thread.sleep(2000);
        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }


}
