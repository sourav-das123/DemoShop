package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register

{
    @FindBy(linkText = "Register")
    public WebElement RegisterUser;

    @FindBy(id = "gender-male")
    public WebElement GenderRadioBtn;

    @FindBy(id = "FirstName")
    public WebElement RegisterFirstName;

    @FindBy(id = "LastName")
    public WebElement RegisterLastName;

    @FindBy(id = "Email")
    public WebElement RegisterEmailUser;

    @FindBy(id = "Password")
    public WebElement RegisterPassword;

    @FindBy(id = "ConfirmPassword")
    public WebElement RegisterConfirmPassword;

    @FindBy(id = "register-button")
    public WebElement RegisterBtn;

    @FindBy(xpath = "(//input[@type='button'])[2]")
    public WebElement RegisterContinue;

    public static Register initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Register.class);
    }
}
