package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SignInPage {

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "section[id='ae-main-content'] h1")
    public WebElement signInHeading;

    @FindBy (css = "div[class='column-1']>p")
    public WebElement newToCarsParagraph;

    @FindBy (id = "email")
    public WebElement emailInputBox;

    @FindBy (id = "password")
    public WebElement passwordInputBox;

    @FindBy (xpath = "(//label[@class='sds-label'])[1]")
    public WebElement emailInputBoxLabel;

    @FindBy (xpath = "(//label[@class='sds-label'])[2]")
    public WebElement passwordInputBoxLabel;

    @FindBy (css = ".sds-helper-text")
    public WebElement minimumCharsParagraph;

    @FindBy (css = "a[href='/forgot_password/?email=']")
    public WebElement forgetPasswordLink;

    @FindBy (css = ".sds-disclaimer")
    public WebElement disclaimerParagraph;

    @FindBy (css = "div[class='sds-field']>button")
    public WebElement signInButton;

    @FindBy (css = ".sds-heading--3")
    public WebElement socialsHeading;

    @FindBy (css = ".sidebar-social-login a")
    public List<WebElement> socialMediaButtons; // insertion order: [facebook, google, apple]

    @FindBy (css = ".sds-notification__content")
    public WebElement errorMessage;




}
