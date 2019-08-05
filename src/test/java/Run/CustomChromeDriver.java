package Run;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CustomChromeDriver extends BasicDriver {

    private String HUB = "http://192.168.2.105:4444/wd/hub";

    private ChromeDriver chromeDriver;
    private WebDriverWait wait;

    private static CustomChromeDriver chrome;

    public static CustomChromeDriver getInstance() {
        if (chrome == null) {
            chrome = new CustomChromeDriver();
        }
        return chrome;
    }

    private CustomChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        this.chromeDriver = driver;
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.remoteWebDriver", "bin/chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(HUB), capabilities);
        } catch (MalformedURLException e) {

        }
    }


}
