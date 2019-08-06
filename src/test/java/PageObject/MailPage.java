package PageObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static PageObject.LetterPage.randomBodyText;

public class MailPage extends BasicPage {

    private String divButtonXpath = "//div[@role='button' and text()='%s']";
    private String folderXpath = "//a[@title='%s']";
    private String letterXpath = "//div[@role='main']//tr[@draggable='true']//div[@role='link']" +
            "//*[@data-thread-id][contains(text(), '%s')]";
    private String allTemplatesXpath = "//tr[@aria-labelledby]//div[@role='link']//span[text()='This is a very small letter']" +
            "/parent::span/parent::div/following-sibling::span[contains(text(), '')]";

    public MailPage(String browserName) {
        super(browserName);
    }


    public void clickDivButton(String buttonText) {
        WebElement divButton = basicDriver.findElementByXpath(String.format(divButtonXpath, buttonText));
        basicDriver.click(divButton);
    }


    public void openFolder(String folderLabel) {
        WebElement section = basicDriver.findElementByXpath(String.format(folderXpath, folderLabel));
        basicDriver.click(section);
    }


    public void checkLetterCreated() {
        try {
            WebElement template = basicDriver.findElementByXpath(String.format(letterXpath, randomBodyText));

        } catch (StaleElementReferenceException e) {
            System.out.println("Element does not exist anymore");
        }

    }


    public void openTemplate() {
        WebElement template = basicDriver.findElementByXpath(String.format(letterXpath + "/ancestor::div[@role='link']",
                randomBodyText));
        basicDriver.click(template);
    }


    public void checkTemplateDeleted() {
        List<WebElement> listOfTemplates = basicDriver.findElementListByXpath(allTemplatesXpath);
        for (WebElement template : listOfTemplates) {
            String actualLetterText = template.getText();
            Assert.assertTrue(!actualLetterText.contains(randomBodyText));
        }
    }

}