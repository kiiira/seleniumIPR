package PageObject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static PageObject.LetterPage.randomBodyText;

public class MailPage extends BasicPage {

    private String divButtonXpath = "//div[@role='button' and text()='%s']";
    private String folderXpath = "//a[@title='%s']";
    private String letterXpath = "//div[@role='main']//div[@role='link']//*[@data-thread-id]/text()";
    private String allTemplatesXpath = "//tr[@aria-labelledby]//div[@role='link']//span[text()='This is a very small letter']" +
            "/parent::span/parent::div/following-sibling::span[contains(text(), '')]";


    public void clickDivButton(String buttonText) {
        WebElement divButton = webDriver.findElementByXpath(String.format(divButtonXpath, buttonText));
        webDriver.click(divButton);
    }


    public void openFolder(String folderLabel) {
        WebElement section = webDriver.findElementByXpath(String.format(folderXpath, folderLabel));
        webDriver.click(section);
    }


    public void checkLetterCreated() {
        WebElement template = webDriver.findElementByXpath(letterXpath);
        String extractedText = template.getText();
        Assert.assertEquals(extractedText, randomBodyText);
    }


    public void openTemplate() {
        WebElement template = webDriver.findElementByXpath(String.format(letterXpath + "/ancestor::div[@role='link']",
                randomBodyText));
        webDriver.click(template);
    }


    public void checkTemplateDeleted() {
        List<WebElement> listOfTemplates = webDriver.findElementListByXpath(allTemplatesXpath);
        for (WebElement template : listOfTemplates) {
            String actualLetterText = template.getText();
            Assert.assertTrue(!actualLetterText.contains(randomBodyText));
        }
    }

}