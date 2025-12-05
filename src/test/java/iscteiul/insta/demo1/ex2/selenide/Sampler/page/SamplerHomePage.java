package iscteiul.insta.demo1.ex2.selenide.Sampler.page;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class SamplerHomePage {

    private static final String URL = "https://demo.vaadin.com/sampler/";

    public void openPage() {
        open(URL);
        $("body").shouldBe(visible, Duration.ofSeconds(10));
    }

    public void accessInteractionComponent(String componentName) {
        // Encontra o texto
        SelenideElement textElement = $(byText(componentName));

        // Espera que esteja visível
        textElement.shouldBe(visible, Duration.ofSeconds(10));

        // Alinha ao fundo para evitar o menu de topo
        textElement.scrollIntoView(false);

        // --- CORREÇÃO DE CLIQUE ---
        // Clicamos no PARENTE do texto.
        // Frequentemente o 'span' com o texto não é clicável, mas o botão/div à volta é.
        // Mantemos o JS click para garantir que nada intercepta.
        textElement.parent().click(ClickOptions.usingJavaScript());
    }

    public void validatePageLoaded(String componentName) {
        // --- CORREÇÃO DE TIMING ---
        // Em vez de verificar apenas uma vez (o que falha se a app for lenta),
        // usamos o Selenide para ESPERAR que o URL mude.
        // Isto aguarda até ao timeout configurado (10s) para o URL conter "button".
        webdriver().shouldHave(urlContaining(componentName.toLowerCase()));
    }
}