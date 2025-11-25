package iscteiul.insta.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUpload {

    @FindBy(id="upload")
    public WebElement fileUpload;

    @FindBy(xpath = "//*[@id='file-upload']")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@id='file-submit']")
    public WebElement submitButton;

    public FileUpload(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
