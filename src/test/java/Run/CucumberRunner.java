package Run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Run",
        plugin = "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final Logger LOG = LogManager.getLogger(CucumberRunner.class);

    @Parameters({"browserName"})
    @BeforeTest()
    public void setUp(String browserName) {

        LOG.info("Set up " + browserName + " browser.");
        LOG.info("Thread id is " + Thread.currentThread().getId());
    }
}
