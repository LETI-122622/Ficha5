package iscteiul.insta.demo1.ex2.selenide.Sampler.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import iscteiul.insta.demo1.ex2.selenide.Sampler.page.SamplerHomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class SamplerInteractionTest {

    SamplerHomePage samplerPage = new SamplerHomePage();

    @BeforeAll
    public static void setUpAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000; // 10 segundos de espera
        Configuration.headless = false;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        samplerPage.openPage();
    }

    @Test
    public void testAccessButtonComponent() {
        String componentToSelect = "Button";

        // 1. Navegar
        samplerPage.accessInteractionComponent(componentToSelect);

        // 2. Validar (Agora espera dinamicamente pelo URL)
        samplerPage.validatePageLoaded(componentToSelect);
    }
}