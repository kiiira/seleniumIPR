package Run;

import org.openqa.selenium.PageLoadStrategy;
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


    /**
     * Selenium hub URL
     */
    private String HUB = "http://192.168.2.105:4444/wd/hub";


    /**
     * Explicit wait instance.
     */
    private WebDriverWait wait;


    /**
     * Singleton pattern to create CustomFirefoxDriver setup instance.
     *
     * @return CustomFirefoxDriver instance if it doesn't exist.
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

        wait = new WebDriverWait(remoteWebDriver, 10);
        System.setProperty("webdriver.gecko.driver", "bin/geckodriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        remoteWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().window().maximize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, BrowserType.FIREFOX);

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
