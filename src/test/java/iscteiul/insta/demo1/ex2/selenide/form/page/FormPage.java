package iscteiul.insta.demo1.ex2.selenide.form.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {

    private SelenideElement firstNameInput() {
        return $x("(//vaadin-text-field)[1]").shouldBe(visible);
    }

    private SelenideElement lastNameInput() {
        return $x("(//vaadin-text-field)[2]").shouldBe(visible);
    }

    private SelenideElement userHandleInput() {
        return $x("(//vaadin-text-field)[3]").shouldBe(visible);
    }

    private SelenideElement wantedPasswordInput() {
        return $x("(//vaadin-password-field)[1]").shouldBe(visible);
    }

    private SelenideElement passwordInput() {
        return $x("(//vaadin-password-field)[2]").shouldBe(visible);
    }

    private SelenideElement marketingCheckbox() {
        return $x("(//vaadin-checkbox)[1]").shouldBe(visible);
    }

    private SelenideElement emailInput() {
        return $x("(//vaadin-email-field)[1]").shouldBe(visible);
    }

    private SelenideElement joinCommunityButton() {
        return $x("(//vaadin-button)[1]").shouldBe(visible);
    }

    private void setVaadinValue(SelenideElement hostComponent, String value) {
        executeJavaScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new CustomEvent('value-changed', " +
                        "{detail: {value: arguments[1]}}));",
                hostComponent, value
        );
    }

    @Step
    public void setFirstNameInput(String firstName) {
        setVaadinValue(firstNameInput(), firstName);
    }

    @Step
    public void setLastNameInput(String lastName) {
        setVaadinValue(lastNameInput(), lastName);
    }

    @Step
    public void setUserHandleInput(String userHandle) {
        setVaadinValue(userHandleInput(), userHandle);
    }

    @Step
    public void setWantedPasswordInput(String  wantedPassword) {
        setVaadinValue(wantedPasswordInput(), wantedPassword);
    }

    @Step
    public void setPasswordInput(String password) {
        setVaadinValue(passwordInput(), password);
    }

    @Step
    public void marketingButtonClick() {
        marketingCheckbox().click();
    }

    @Step
    public void setEmailInput(String email) {
        setVaadinValue(emailInput(), email);
    }

    @Step
    public void joinCommunityButtonClick() {
        joinCommunityButton().click();
    }
}
