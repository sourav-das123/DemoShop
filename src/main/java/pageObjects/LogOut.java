package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {

    @FindBy(linkText = "Log out")
    public WebElement Logout;

    public static LogOut initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, LogOut.class);
    }
}
