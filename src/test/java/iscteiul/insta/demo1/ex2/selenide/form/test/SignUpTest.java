package iscteiul.insta.demo1.ex2.selenide.form.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import iscteiul.insta.demo1.ex2.selenide.form.page.FormPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class SignUpTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://vaadin-form-example.demo.vaadin.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }

    @Test
    @Description("Criar uma nova conta para entrar na comunidade.")
    void shouldSignUpNewUser() throws InterruptedException {
        open(".", FormPage.class);

        FormPage formPage = new FormPage();

        formPage.setFirstNameInput("John");
        formPage.setLastNameInput("Doe");
        formPage.setUserHandleInput("johndoe123");
        formPage.setWantedPasswordInput("SecurePass123!");
        formPage.setPasswordInput("SecurePass123!");

        formPage.marketingButtonClick();

        formPage.setEmailInput("johndoe@gmail.com");

        //formPage.joinCommunityButtonClick();

        Thread.sleep(1000);
    }
}