package Run;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasicDriver {


    /**
     * Chrome remoteWebDriver && Explicit wait instances
     */
    protected static RemoteWebDriver remoteWebDriver;
    protected WebDriverWait wait;


    /**
     * Selenium "get" method wrapper
     *
     * @param url to navigate
     */
    public void get(String url) {
        remoteWebDriver.get(url);
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
     * Selenium "click" wrapper
     *
     * @param element web element
     */
    public void click(WebElement element) {
        element.click();
    }


    /**
     * JavaScriptExecutor "scrollTo" wrapper
     *
     * @param element web element
     */
    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) remoteWebDriver).executeScript("arguments[0].scrollIntoView(true);", element);
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
        remoteWebDriver.close();
        remoteWebDriver.quit();
    }


    /**
     * Takes screenshot
     *
     * @return screenshot image in Bytes
     */
    public static byte[] getScreenshot() {
        return (((TakesScreenshot) remoteWebDriver).getScreenshotAs(OutputType.BYTES));
    }

}
