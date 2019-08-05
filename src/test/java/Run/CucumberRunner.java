package Run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Run",
        plugin = "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        tags = "@Gmail")
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final Logger LOG = LogManager.getLogger(CucumberRunner.class);

    @Parameters({"browserName"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            DesiredCapabilities caps = new DesiredCapabilities();
            chromeOptions.merge(caps);
            CustomChromeDriver driver = CustomChromeDriver.getInstance();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            DesiredCapabilities caps = new DesiredCapabilities();
            firefoxOptions.merge(caps);
            CustomChromeDriver driver = CustomChromeDriver.getInstance();
//            CustomFirefoxDriver driver = new CustomFirefoxDriver.getInstance();
        }

        LOG.info("SetUp " + browserName + " browser.");
        LOG.info("Thread id is " + Thread.currentThread().getId());
    }

    @AfterTest
    public void tearDown() {
        //TODO: tear down
    }

}
