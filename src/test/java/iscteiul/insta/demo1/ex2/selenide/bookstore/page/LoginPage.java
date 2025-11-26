package iscteiul.insta.demo1.ex2.selenide.bookstore.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import iscteiul.insta.demo1.ex2.selenide.bookstore.page.InventoryPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    // AJUSTAR estes seletores com o inspector do browser
    @FindBy(css = "input[name='username'], input[placeholder='Username']")
    private SelenideElement usernameInput;

    @FindBy(css = "input[name='password'], input[type='password']")
    private SelenideElement passwordInput;


    @Step("Login com utilizador {username}")
    public InventoryPage loginAs(String username, String password) {
        usernameInput.setValue(username);
        // em vez de clicar no botão, fazemos ENTER na password
        passwordInput.setValue(password).pressEnter();
        return page(InventoryPage.class);
    }
}
