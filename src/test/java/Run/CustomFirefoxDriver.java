package Run;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CustomFirefoxDriver extends BasicDriver {


    /**
     * Selenium hub URL
     */
    private String HUB = "http://localhost:4444/wd/hub";


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

        System.setProperty("webdriver.gecko.driver", "bin/geckodriver.exe");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("firefox");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        capabilities.merge(options);

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {
            System.err.println("Couldn't reach HUB");
            e.printStackTrace();
        }


        wait = new WebDriverWait(remoteWebDriver, 10);

        remoteWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().window().maximize();

    }

}
