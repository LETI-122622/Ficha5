package iscteiul.insta.demo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxesTest {

    private WebDriver driver;
    private CheckboxesPage checkboxesPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.open();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkAndUncheckCheckboxes() throws InterruptedException {
        // Garantir estado inicial (não é obrigatório mas ajuda a perceber)
        // checkbox1 começa desmarcada, checkbox2 começa marcada.

        // 1) Marcar a primeira
        checkboxesPage.checkFirst();
        Thread.sleep(2000);
        assertTrue(checkboxesPage.checkbox1.isSelected());

        // 2) Desmarcar a segunda
        checkboxesPage.uncheckSecond();
        Thread.sleep(2000);
        assertFalse(checkboxesPage.checkbox2.isSelected());
    }
}
