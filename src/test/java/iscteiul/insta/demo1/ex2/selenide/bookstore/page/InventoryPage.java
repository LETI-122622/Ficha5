package iscteiul.insta.demo1.ex2.selenide.bookstore.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class InventoryPage {

    // Grelha de produtos
    @FindBy(css = "vaadin-grid")
    private SelenideElement productsGrid;

    // Botão "New product"
    @FindBy(xpath = "//vaadin-button[contains(.,'New product')]")
    private SelenideElement newProductButton;

    @Step("Abrir formulário para novo produto")
    public NewProductPage clickNewProduct() {
        newProductButton.shouldBe(visible).click();
        return com.codeborne.selenide.Selenide.page(NewProductPage.class);
    }

    @Step("Verificar se produto '{productName}' aparece na tabela")
    public void shouldContainProduct(String productName) {
        // garantir que a grelha está visível
        productsGrid.shouldBe(visible);

        // 👉 forçar o Vaadin a renderizar TODAS as linhas
        // scroll até ao último índice disponível
        executeJavaScript(
                "if (arguments[0].items && arguments[0].items.length) {" +
                        "  arguments[0].scrollToIndex(arguments[0].items.length - 1);" +
                        "}",
                productsGrid
        );

        // agora o texto do novo produto já deve existir no DOM
        productsGrid.shouldHave(text(productName));
    }
}
