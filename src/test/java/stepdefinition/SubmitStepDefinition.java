package stepdefinition;

import base.TestBase;
import dataProvider.ExcelReader;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageObjects.Login;
import pageObjects.SubmitOrder;

import java.util.HashMap;
import java.util.List;

public class SubmitStepDefinition extends TestBase
{
    private TestBase testBase;
    public List<HashMap<String, String>> SearchType;
    public List<HashMap<String, String>> SubmitType;

    public SubmitStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
        SearchType = ExcelReader.GetTestData("SearchTypeScenarios");
        SubmitType = ExcelReader.GetTestData("SubmitTypeScenarios");
        //SortingAndFiltering = ExcelReader.GetTestData("SortingFilterScenarios");
    }

    @Given("^Click on CheckOut \"(.*)\"$")
    public void CheckOutOrder(String Type)
    {
        try
        {
            int index = Integer.parseInt(Type)-1;
            SubmitOrder.initiate(testBase.driver).ZipCode.sendKeys(SubmitType.get(index).get("ZIPCode"));
            SubmitOrder.initiate(testBase.driver).TermsService.click();
            SubmitOrder.initiate(testBase.driver).CheckOut.click();

        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given("^Validate the CheckOut details \"(.*)\"$")
    public void CheckOutDetails(String Checkout)
    {
        try
        {
            int index = Integer.parseInt(Checkout)-1;
            /*String chktxt = SubmitOrder.initiate(testBase.driver).CheckOutText.getText();
            if (chktxt == "Checkout")
            {
                testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).CheckOutText);
                testBase.SelectDropdown("New Address",SubmitOrder.initiate(testBase.driver).BillingAddress);
                testBase.pause();*/
                testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).Country);
                testBase.SelectDropdown("India",SubmitOrder.initiate(testBase.driver).Country);
                SubmitOrder.initiate(testBase.driver).BillingCity.sendKeys(SubmitType.get(index).get("City"));
                SubmitOrder.initiate(testBase.driver).BillingAddressOne.sendKeys(SubmitType.get(index).get("AddressOne"));
                SubmitOrder.initiate(testBase.driver).BillingAddressOne.sendKeys(SubmitType.get(index).get("AddressTwo"));
                SubmitOrder.initiate(testBase.driver).BillingCode.sendKeys(SubmitType.get(index).get("Code"));
                SubmitOrder.initiate(testBase.driver).BillingPhone.sendKeys(SubmitType.get(index).get("Phone"));
                SubmitOrder.initiate(testBase.driver).ContinueBtn.click();


        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given("^Validate the shipping method")
    public void ShippingMethod()
    {
        try
        {
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).ShippingBtn);
            SubmitOrder.initiate(testBase.driver).ShippingBtn.click();
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).ShippingOption);
            SubmitOrder.initiate(testBase.driver).ShippingOption1.click();
            SubmitOrder.initiate(testBase.driver).ShippingMethodBtn.click();
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).PaymentMethodBtn);
            SubmitOrder.initiate(testBase.driver).PaymentMethodOption.click();
            SubmitOrder.initiate(testBase.driver).PaymentMethodBtn.click();

        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given("^Validate the payment method \"(.*)\"$")
    public void PaymentMethod(String Payment)
    {
        try
        {
            int index = Integer.parseInt(Payment)-1;
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).PaymentMethodOption);
            SubmitOrder.initiate(testBase.driver).PaymentMethodOption.click();
            SubmitOrder.initiate(testBase.driver).PaymentMethodBtn.click();
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).CardType);
            testBase.SelectDropdown("Master card",SubmitOrder.initiate(testBase.driver).CardType);
            SubmitOrder.initiate(testBase.driver).HolderName.sendKeys(SubmitType.get(index).get("CardName"));
            SubmitOrder.initiate(testBase.driver).CardNumber.sendKeys(SubmitType.get(index).get("CardNumber"));
            testBase.SelectDropdown("06",SubmitOrder.initiate(testBase.driver).ExpiryMonth);
            testBase.SelectDropdown("2022",SubmitOrder.initiate(testBase.driver).ExpiryYear);
            SubmitOrder.initiate(testBase.driver).CodeOfCard.sendKeys(SubmitType.get(index).get("Cardcode"));
            SubmitOrder.initiate(testBase.driver).PaymentInfoBtn.click();
            testBase.WaitTillElementClickable(SubmitOrder.initiate(testBase.driver).ConfirmOrder);
            SubmitOrder.initiate(testBase.driver).ConfirmOrder.click();
        }

        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
