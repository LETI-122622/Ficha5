package iscteiul.insta.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DynamicContentPage {

    private final WebDriver driver;

    // Localiza todos os parágrafos de conteúdo dinâmico
    @FindBy(css = "#content .row .large-10.columns")
    public List<WebElement> contentBlocks;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_content");
    }

    public String getAllContentText() {
        StringBuilder sb = new StringBuilder();
        for (WebElement block : contentBlocks) {
            sb.append(block.getText()).append("\n");
        }
        return sb.toString();
    }
}

