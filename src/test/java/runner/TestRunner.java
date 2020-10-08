package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/"},
        plugin = {"pretty", "html:target/Destination/index.html"},
        glue = "stepdefinition"
)

public class TestRunner extends AbstractTestNGCucumberTests {


}
