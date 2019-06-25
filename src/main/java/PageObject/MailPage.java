package PageObject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static HelpfulStuff.HelpfulShizzle.wordGenerator;

public class MailPage extends BasicPage {

    String randomSubjectText = null;

    private String divButtonXpath = "//div[@role='button' and text()='%s']";
    private String textAreaFieldXpath = "//textarea[@aria-label='%s']";
    private String inputFieldXpath = "//input[@aria-label='%s']";
    private String divTextFieldXpath = "//div[@aria-label='%s']";
    private String titleBarButtonXpath = "//img[@aria-label='%s']";
    private String folderXpath = "//a[@title='%s']";
    private String letterXpath = "//div[@role='link']//span[@data-thread-id]";
    private String checkAddresseeXpath = "//span[@email]/ancestor::div[@tabindex='1']";
    private String checkSubjectBoxXpath = "//input[@name='subjectbox']";
    private String checkLetterBodyXpath = "//div[@role='textbox']";
    private String letterWindowButtonXpath = "//div[@role = 'button' and contains(@aria-label, '%s')]";
    private String allTemplatesXpath = "//tr[@aria-labelledby]//div[@role='link']//span[text()='This is a very small letter']" +
            "/parent::span/parent::div/following-sibling::span[contains(text(), '')]";


    public void clickDivButton(String buttonText) {
        WebElement divButton = webDriver.findElementByXpath(String.format(divButtonXpath, buttonText));
        webDriver.click(divButton);
    }


    public void fillTextAreaElementWithValue(String fieldName, String value) {
        WebElement textAreaElement = webDriver.findElementByXpath(String.format(textAreaFieldXpath, fieldName));
        webDriver.input(textAreaElement, value);
    }


    public void fillInputElementWithRandomValue(String fieldName) {
        randomSubjectText = wordGenerator();
        WebElement inputElement = webDriver.findElementByXpath(String.format(inputFieldXpath, fieldName));
        webDriver.input(inputElement, randomSubjectText);
    }


    public void fillDivTextFieldWithValue(String fieldName, String value) {
        WebElement divTextFieldElement = webDriver.findElementByXpath(String.format(divTextFieldXpath, fieldName));
        webDriver.input(divTextFieldElement, value);
    }


    public void pressTitleBarButton(String buttonText) {
        WebElement titleBarButton = webDriver.findElementByXpath(String.format(titleBarButtonXpath, buttonText));
        webDriver.click(titleBarButton);
    }


    public void openFolder(String folderLabel) {
        WebElement section = webDriver.findElementByXpath(String.format(folderXpath, folderLabel));
        webDriver.click(section);
    }


    public void checkLetterCreated() {
        WebElement template = webDriver.findElementByXpath(letterXpath);
        Assert.assertEquals(randomSubjectText, template.getText());
    }


    public void openTemplate() {
        WebElement template = webDriver.findElementByXpath(String.format(letterXpath + "/ancestor::div[@role='link']",
                randomSubjectText));
        webDriver.click(template);
    }


    public void checkAddressee(String expectedAddressee) {
        WebElement addressee = webDriver.findElementByXpath(checkAddresseeXpath);
        Assert.assertEquals(addressee.getText(), expectedAddressee);
    }


    public void checkSubjectBox(String expectedSubjectText) {
        WebElement subjectBox = webDriver.findElementByXpath(checkSubjectBoxXpath);
        Assert.assertEquals(subjectBox.getAttribute("value"), expectedSubjectText);
    }


    public void checkLetterBody() {
        String expectedLetterBody = randomSubjectText;
        WebElement letterBody = webDriver.findElementByXpath(checkLetterBodyXpath);
        Assert.assertEquals(letterBody.getText(), expectedLetterBody);
    }


    public void clickButtonInLetterWindow(String buttonLabel) {
        WebElement letterWindowButton = webDriver.findElementByXpath(String.format(letterWindowButtonXpath,
                buttonLabel));
        webDriver.click(letterWindowButton);
    }


    public void checkTemplateDeleted() {
        List<WebElement> listOfTemplates = webDriver.findElementListByXpath(allTemplatesXpath);
        for (WebElement template : listOfTemplates) {
            String actualLetterText = template.getText();
            Assert.assertTrue(!actualLetterText.contains(randomSubjectText));
        }
    }

}

