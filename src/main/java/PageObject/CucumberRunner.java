package PageObject;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static Config.Utilities.WebDriver.webDriver;

//TODO: move browser config to before
// and set up window handler

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"PageObject"},
        tags = "@Test")
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {

    }


    @AfterSuite
    public void tearDown() {
//        webDriver.close();
    }
}
