package stepdefinition;

import base.TestBase;
import dataProvider.ExcelReader;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageObjects.LogOut;
import pageObjects.Register;

import java.util.HashMap;
import java.util.List;

public class RegisterStepDefinition extends  TestBase
{

        private TestBase testBase;
        public List<HashMap<String, String>> SearchType;
        public List<HashMap<String, String>> SubmitType;

        public RegisterStepDefinition(TestBase testBase)
        {
            this.testBase=testBase;
            SearchType = ExcelReader.GetTestData("SearchTypeScenarios");
            SubmitType = ExcelReader.GetTestData("SubmitTypeScenarios");
            //SortingAndFiltering = ExcelReader.GetTestData("SortingFilterScenarios");
        }

        @Given("^Register as a user \"(.*)\"$")
        public void Register(String register)
        {
            try
            {
                int index = Integer.parseInt(register)-1;
                Register.initiate(testBase.driver).RegisterUser.click();
                testBase.WaitTillElementClickable(Register.initiate(testBase.driver).GenderRadioBtn);
                Register.initiate(testBase.driver).GenderRadioBtn.click();
                Register.initiate(testBase.driver).RegisterFirstName.sendKeys(SearchType.get(index).get("FirstName"));
                Register.initiate(testBase.driver).RegisterLastName.sendKeys(SearchType.get(index).get("LastName"));
                Register.initiate(testBase.driver).RegisterEmailUser.sendKeys(SearchType.get(index).get("RegisterEmail"));
                Register.initiate(testBase.driver).RegisterPassword.sendKeys(SearchType.get(index).get("RegisterPassword"));
                Register.initiate(testBase.driver).RegisterConfirmPassword.sendKeys(SearchType.get(index).get("RegisterConfirmPwd"));
                Register.initiate(testBase.driver).RegisterBtn.click();
                testBase.WaitTillElementClickable(Register.initiate(testBase.driver).RegisterContinue);
                Register.initiate(testBase.driver).RegisterContinue.click();
                LogOut.initiate(testBase.driver).Logout.click();

            }

            catch (AssertionError | Exception e)
            {
                e.printStackTrace();
                Assert.fail();
            }
        }

    }
