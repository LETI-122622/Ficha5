package iscteiul.insta.demo1.ex2.selenide.bookstore.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import iscteiul.insta.demo1.ex2.selenide.bookstore.page.InventoryPage;
import iscteiul.insta.demo1.ex2.selenide.bookstore.page.LoginPage;
import iscteiul.insta.demo1.ex2.selenide.bookstore.page.NewProductPage;



@Epic("Bookstore")
@Feature("Inventory")
@Story("Adicionar um produto")
@Severity(SeverityLevel.CRITICAL)
public class AddProductTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://vaadin-bookstore-example.demo.vaadin.com";
        //Configuration.browserSize = "maximize";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }

    @Test
    @Description("Login como admin, adicionar um novo produto e verificar que aparece na lista.")
    void shouldAddNewProductToInventory() throws InterruptedException {

        String productName = "Selenium Testing " + System.currentTimeMillis();
        String price = "19.90";
        String stock = "7";
        String avaliability = "Available";
        String[] categorys = {"Romance", "Sci-fi"};

        // 1. abrir página (login aparece primeiro)
        LoginPage loginPage = open("/Inventory/", LoginPage.class);

        //Thread.sleep(500000);

        // 2. login
        InventoryPage inventoryPage = loginPage.loginAs("admin", "admin");

        //Thread.sleep(500000);

        // 3. clicar em New product
        NewProductPage newProductPage = inventoryPage.clickNewProduct();

        //Thread.sleep(500000);

        /// 4. preencher formulário e guardar
        newProductPage.setProductName(productName);
        newProductPage.setPrice(price);
        newProductPage.setStock(stock);
        newProductPage.setAvailability(avaliability);
        newProductPage.selectCategories(categorys);

        inventoryPage = newProductPage.save();

        //Thread.sleep(500000);

        // 5. verificar que o produto aparece na tabela
        inventoryPage.shouldContainProduct(productName);
        //assertTrue(inventoryPage.hasProduct(productName));
    }
}
