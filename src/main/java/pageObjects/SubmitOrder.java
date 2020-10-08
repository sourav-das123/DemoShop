package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitOrder
{
    @FindBy(id = "ZipPostalCode")
    public WebElement ZipCode;

    @FindBy(id = "termsofservice")
    public WebElement TermsService;

    @FindBy(id = "checkout")
    public WebElement CheckOut;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    public WebElement CheckOutText;

    @FindBy(id = "billing-address-select")
    public WebElement BillingAddress;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement Country;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement BillingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement BillingAddressOne;

    @FindBy(id = "BillingNewAddress_Address2")
    public WebElement BillingAddressTwo;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement BillingCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement BillingPhone;

    @FindBy(xpath = "(//input[@title='Continue'])[1]")
    public WebElement ContinueBtn;

    @FindBy(xpath = "(//p[contains(@class,'back-link')]//following::input)[1]")
    public WebElement ShippingBtn;

    @FindBy(id = "shippingoption_0")
    public WebElement ShippingOption;

    @FindBy(id = "shippingoption_1")
    public WebElement ShippingOption1;

    @FindBy(xpath = "(//p[contains(@class,'back-link')]//following::input)[5]")
    public WebElement ShippingMethodBtn;

    @FindBy(xpath = "(//input[@value='Continue'])[4]")
    public WebElement PaymentMethodBtn;

    @FindBy(id = "paymentmethod_2")
    public WebElement PaymentMethodOption;

    @FindBy(xpath = "//select[@id='CreditCardType']")
    public WebElement CardType;

    @FindBy(id = "CardholderName")
    public WebElement HolderName;

    @FindBy(id = "CardNumber")
    public WebElement CardNumber;

    @FindBy(id = "ExpireMonth")
    public WebElement ExpiryMonth;

    @FindBy(id = "ExpireYear")
    public WebElement ExpiryYear;

    @FindBy(id = "CardCode")
    public WebElement CodeOfCard;

    @FindBy(xpath = "(//p[contains(@class,'back-link')]//following::input)[14]")
    public WebElement PaymentInfoBtn;

    @FindBy(xpath = "(//input[@value='Confirm'])")
    public WebElement ConfirmOrder;


    public static SubmitOrder initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, SubmitOrder.class);
    }
}
