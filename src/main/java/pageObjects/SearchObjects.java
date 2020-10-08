package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchObjects {

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    public WebElement SearchBtn;

    @FindBy(linkText = "Books")
    public WebElement BooksTab;

    @FindBy(id = "products-orderby")
    public WebElement SortBy;

    @FindBy(id = "products-pagesize")
    public WebElement Display;

    @FindBy(xpath = "//div[@class='filter-content']//li[1]")
    public WebElement UnderBtn;

    @FindBy(linkText = "Remove Filter")
    public WebElement RemoveFilterBtn;

    @FindBy(xpath = "//div[@class='product-grid']/div[3]//input")
    public WebElement Productid;

    @FindBy(linkText = "Shopping cart")
    public WebElement ShoppingCart;





    public static SearchObjects initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, SearchObjects.class);
    }

}
