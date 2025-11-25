package iscteiul.insta.demo1.ex1b.complex.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    @FindBy(id="upload")
    public WebElement fileUpload;

    @FindBy(xpath = "//*[@id='file-upload']")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@id='file-submit']")
    public WebElement submitButton;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
