package Run;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class CustomFirefoxDriver extends BasicDriver {


    private String HUB = "http://192.168.2.105:4444/wd/hub";


    /**
     * Driver & explicit wait instances.
     */
    private FirefoxDriver firefoxDriver;
    private WebDriverWait wait;


    /**
     * Singleton pattern to create BasicDriver setup instance.
     *
     * @return remoteWebDriver instance if it doesn't exist.
     */
    private static CustomFirefoxDriver gecko;


    public static CustomFirefoxDriver getInstance() {
        if (gecko == null) {
            gecko = new CustomFirefoxDriver();
        }
        return gecko;
    }


    /**
     * Class set up constructor.
     */
    private CustomFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxDriver driver = new FirefoxDriver(options);
        this.firefoxDriver = driver;
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.gecko.remoteWebDriver", "bin/geckodriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, BrowserType.FIREFOX);
        capabilities.setBrowserName("firefox");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {

        }
    }

}
