package iscteiul.insta.demo1.ex2.selenide.bookstore.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.page;

public class NewProductPage {

    // ---------- HOSTS VAADIN ----------

    // 1º vaadin-text-field -> Product name
    private SelenideElement productNameHost() {
        return $x("(//vaadin-text-field)[2]").shouldBe(visible);
    }

    // 2º vaadin-text-field -> Price
    private SelenideElement priceHost() {
        return $x("(//vaadin-text-field)[3]").shouldBe(visible);
    }

    // 3º vaadin-text-field -> In stock
    private SelenideElement stockHost() {
        return $x("(//vaadin-text-field)[4]").shouldBe(visible);
    }

    // dropdown de Availability
    private SelenideElement availabilityHost() {
        return $x("//vaadin-select").shouldBe(visible);
    }

    // ---------- HELPER GENÉRICO PARA DEFINIR VALOR NUM VAADIN FIELD ----------

    private void setVaadinValue(SelenideElement hostComponent, String value) {
        executeJavaScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new CustomEvent('value-changed', " +
                        "{detail: {value: arguments[1]}}));",
                hostComponent, value
        );
    }

    // ---------- AÇÕES PÚBLICAS ----------

    @Step("Preencher nome do produto: {name}")
    public NewProductPage setProductName(String name) {
        setVaadinValue(productNameHost(), name);
        return this;
    }

    @Step("Preencher preço: {price}")
    public NewProductPage setPrice(String price) {
        setVaadinValue(priceHost(), price);
        return this;
    }

    @Step("Preencher stock: {stock}")
    public NewProductPage setStock(String stock) {
        setVaadinValue(stockHost(), stock);
        return this;
    }

    @Step("Selecionar disponibilidade: {availability}")
    public NewProductPage setAvailability(String availability) {
        availabilityHost().click();
        $x(String.format("//vaadin-item[contains(.,'%s')]", availability))
                .shouldBe(visible)
                .click();
        return this;
    }

    // ---------- CHECKBOXES DE CATEGORIAS ----------

    // helper genérico por índice
    private SelenideElement categoryCheckbox(int index) {
        return $x("(//vaadin-checkbox)[" + index + "]").shouldBe(visible);
    }

    @Step("Selecionar categorias: {categories}")
    public NewProductPage selectCategories(String... categories) {

        for (String category : categories) {

            // cada checkbox é um <vaadin-checkbox> com texto lá dentro
            SelenideElement checkbox = $x(
                    String.format("//vaadin-checkbox[contains(.,'%s')]", category)
            ).shouldBe(visible);

            // clicar de forma segura
            checkbox.click();
        }

        return this;
    }

    // Botão "Save"
    @FindBy(xpath = "//vaadin-button[contains(.,'Save')]")
    private SelenideElement saveButton;

    @Step("Salvar o novo produto no inventário")
    public InventoryPage save() {
        saveButton.shouldBe(visible).click();
        return page(InventoryPage.class);
    }
}
