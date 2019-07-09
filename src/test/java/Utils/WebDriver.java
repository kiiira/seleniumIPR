package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
     * Selenium findElements(By.xpath()) wrapper
     *
     * @param xpath selector
     * @return list of elements found by xpath
     */
    public List<WebElement> findElementListByXpath(String xpath) {
        List<WebElement> listOfElements = null;
        for (int i = 0; i < 3; i++) {
            try {
                listOfElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
                return listOfElements;
            } catch (StaleElementReferenceException se) {
                continue;
            }
        }
        return listOfElements;
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
        element.sendKeys(Keys.BACK_SPACE);
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
