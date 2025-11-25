package iscteiul.insta.demo1.ex1b.basic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {

    private WebDriver driver;

    // URL da página de checkboxes
    public static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void checkFirst() {
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void uncheckSecond() {
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
    }
}
