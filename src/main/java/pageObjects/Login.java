package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(linkText = "Log in")
    public WebElement Loginbtn;

    @FindBy(id = "Email")
    public WebElement UserEmail;

    @FindBy(id = "Password")
    public WebElement UserPassword;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement SubmitBtn;


    public static Login initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Login.class);
    }

}
