package stepdefinition;

import base.TestBase;
import dataProvider.ExcelReader;
import dataProvider.PropertiesReader;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageObjects.LogOut;
import pageObjects.Login;
import pageObjects.SearchObjects;

import java.util.HashMap;
import java.util.List;

public class SearchStepDefinition extends TestBase
{

    private TestBase testBase;
    public List<HashMap<String, String>> SearchType;
    //public List<HashMap<String, String>> AssignContractData;
    //public List<HashMap<String, String>> SortingAndFiltering;

    public SearchStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
        SearchType = ExcelReader.GetTestData("SearchTypeScenarios");
        //AssignContractData = ExcelReader.GetTestData("AssignContractScenarios");
        //SortingAndFiltering = ExcelReader.GetTestData("SortingFilterScenarios");
    }

    @Given("^Login as a user \"(.*)\"$")
    public void LoginUser(String User)
    {
        try
        {
            int index = Integer.parseInt(User)-1;
            testBase.WaitTillElementClickable(Login.initiate(testBase.driver).Loginbtn);
            Login.initiate(testBase.driver).Loginbtn.click();
            testBase.WaitTillElementClickable(Login.initiate(testBase.driver).UserEmail);
            Login.initiate(testBase.driver).UserEmail.sendKeys(SearchType.get(index).get("UserEmail"));
            Login.initiate(testBase.driver).UserPassword.sendKeys
                    (PropertiesReader.ReadEnvironmentParameters("Pwd"));
            Login.initiate(testBase.driver).SubmitBtn.click();

        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Given("^Select for Books")
    public void SelectionOfBooks()
    {
        try
        {
            testBase.WaitTillElementClickable(SearchObjects.initiate(testBase.driver).SearchBtn);
            SearchObjects.initiate(testBase.driver).BooksTab.click();
            testBase.WaitTillElementClickable(SearchObjects.initiate(testBase.driver).SearchBtn);
            testBase.SelectDropdown("Name: A to Z",SearchObjects.initiate(testBase.driver).SortBy);
            testBase.pause();
            testBase.SelectDropdown("4",SearchObjects.initiate(testBase.driver).Display);
            testBase.pause();
            SearchObjects.initiate(testBase.driver).UnderBtn.click();
            testBase.pause();
            SearchObjects.initiate(testBase.driver).Productid.click();
        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given("^Add Book to the Cart")
    public void ValidateAddToCart()
    {
        try
        {
            testBase.WaitTillElementClickable(SearchObjects.initiate(testBase.driver).ShoppingCart);
            SearchObjects.initiate(testBase.driver).ShoppingCart.click();
        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given(("^Click Logout"))
    public void LogOut()
    {
        LogOut.initiate(testBase.driver).Logout.click();
    }

}
