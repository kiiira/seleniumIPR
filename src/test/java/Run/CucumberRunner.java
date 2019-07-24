package Run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static Utils.CustomDriver.customDriver;


@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"Run"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        tags = "@Gmail")
public class CucumberRunner extends AbstractTestNGCucumberTests {



    @BeforeSuite
    public void setUp() {
    }

    @AfterSuite
    public void tearDown() {
        customDriver.close();
    }

}
