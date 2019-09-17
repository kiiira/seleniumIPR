package Run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static PageObject.BasicPage.setUp;
import static PageObject.BasicPage.shutDown;


@CucumberOptions(
        features = "src/test/resources/features"
        , glue = "Run"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {


    /**
     * Browser testNG setup
     *
     * @param browserName browser name to pick up from testng.xml
     */
    @Parameters({"browserName"})
    @BeforeTest()
    public void setUpCall(String browserName) {
        setUp(browserName);
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        shutDown();
    }

}
