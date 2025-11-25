package iscteiul.insta.demo1.ex1b.dynamic.test;

import iscteiul.insta.demo1.ex1b.dynamic.page.DynamicContentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicContentTest {

    private WebDriver driver;
    private DynamicContentPage dynamicContentPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.open();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void contentChangesAfterRefresh() {
        // Conteúdo na primeira carga
        String firstLoadContent = dynamicContentPage.getAllContentText();

        // Fazer refresh da página
        dynamicContentPage.open();

        // Conteúdo na segunda carga
        String secondLoadContent = dynamicContentPage.getAllContentText();

        // Verificar que o conteúdo mudou (dinâmico)
        assertNotEquals(firstLoadContent, secondLoadContent,
                "O conteúdo dinâmico deveria ser diferente após novo carregamento da página.");
    }
}

