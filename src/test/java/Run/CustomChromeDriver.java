package Run;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CustomChromeDriver extends BasicDriver {

    /**
     * Selenium hub URL
     */
    private String HUB = "http://192.168.2.105:4444/wd/hub";


    /**
     * Explicit wait instance.
     */
    private WebDriverWait wait;


    /**
     * Singleton pattern to create CustomChromeDriver setup instance.
     *
     * @return CustomChromeDriver instance if it doesn't exist.
     */


    private static CustomChromeDriver chrome;


    public static CustomChromeDriver getInstance() {
        if (chrome == null) {
            chrome = new CustomChromeDriver();
        }
        return chrome;
    }


    /**
     * Class set up constructor.
     */
    private CustomChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        wait = new WebDriverWait(remoteWebDriver, 10);
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        remoteWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().window().maximize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {

        }
    }


}
