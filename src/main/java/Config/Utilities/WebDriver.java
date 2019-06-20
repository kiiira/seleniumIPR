package Config.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//TODO: fix chromedriver or chrome browser version (an older one needed)

/**
 * ChromeDriver set up:
 */
public class WebDriver {


    /*
    Chrome driver && Explicit wait instances
     */
    ChromeDriver driver;
    WebDriverWait wait;


    /**
     * Singleton pattern to create WebDriver setup instance
     */
    public static WebDriver webDriver;
    public static WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = new WebDriver();
        }
        return webDriver;

    }


    /**
     * Class constructor
     */
    private WebDriver() {
        ChromeDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        //very important one for Chrome version >= 72
        options.addArguments("--disable-features=VizDisplayCompositor");

    }


    /**
     * Selenium findElement(By.xpath()) wrapper
     *
     * @param xpath selector
     * @return element found by xpath
     */
    public WebElement findElementByXpath(String xpath) {
        WebElement element = null;
        for (int i = 0; i < 3; i++) {
            try {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                return element;
            } catch (StaleElementReferenceException se) {
                continue;
            }
        }
        return element;

    }


    /**
     * Selenium findElement(By.cssSelector()) wrapper
     *
     * @param cssSelector selector
     * @return element found by CSS selector
     */
    public WebElement findElementByCssSelector(String cssSelector) {
        WebElement element = null;
        for (int i = 0; i < 5; i++) {
            try {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
                element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
                return element;
            } catch (StaleElementReferenceException se) {
                continue;
            }
        }
        return element;

    }


    /**
     * Selenium "get" method wrapper
     *
     * @param url to navigate
     */
    public void get(String url) {
        driver.get(url);
    }


    /**
     * Selenium "click" wrapper
     *
     * @param element web element
     */
    public void click(WebElement element) {
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    /**
     * JavaScriptExecutor "scrollTo" wrapper
     *
     * @param element web element
     */
    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * Selenium "sendKeys"/"setValue" wrapper
     *
     * @param element web element
     */
    public void input(WebElement element, String keys) {
        element.clear();
        element.sendKeys(keys);
    }


    /**
     * Selenium close & quit wrapper
     */
    public void close() {
        driver.close();
        driver.quit();
    }

}
