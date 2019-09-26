package run;

import config.Utils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CustomChromeDriver extends BasicDriver {


    /**
     * Selenium hub URL
     */
    private String HUB;

    {
        try {
            HUB = Utils.readProperties("hubUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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


        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {
            System.err.println("Couldn't reach HUB");
        }

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        wait = new WebDriverWait(remoteWebDriver, 10);

        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        remoteWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().window().maximize();

    }

}
