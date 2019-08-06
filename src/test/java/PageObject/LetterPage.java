package PageObject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Config.Stuff.HelpfulShizzle.wordGenerator;

public class LetterPage extends BasicPage {


    public static String randomBodyText = null;

    private String textAreaFieldXpath = "//textarea[@aria-label='%s']";
    private String inputFieldXpath = "//input[@aria-label='%s']";
    private String divTextFieldXpath = "//div[@aria-label='%s']";
    private String titleBarButtonXpath = "//img[@aria-label='%s']";
    private String checkAddresseeXpath = "//span[@email]/ancestor::div[@tabindex='1']";
    private String checkSubjectBoxXpath = "//input[@name='subjectbox']";
    private String checkLetterBodyXpath = "//div[@role='textbox']";
    private String letterWindowButtonXpath = "//div[@role = 'button' and contains(@aria-label, '%s')]";

    public LetterPage(String browserName) {
        super(browserName);
    }


    public void fillTextAreaElementWithValue(String fieldName, String value) {
        WebElement textAreaElement = basicDriver.findElementByXpath(String.format(textAreaFieldXpath, fieldName));
        basicDriver.input(textAreaElement, value);
    }


    public void fillInputElementWithRandomValue(String fieldName) {
        WebElement inputElement = basicDriver.findElementByXpath(String.format(inputFieldXpath, fieldName));
        randomBodyText = wordGenerator();
        basicDriver.input(inputElement, randomBodyText);
    }


    public void fillDivTextFieldWithValue(String fieldName, String value) {
        WebElement divTextFieldElement = basicDriver.findElementByXpath(String.format(divTextFieldXpath, fieldName));
        basicDriver.input(divTextFieldElement, value);
    }


    public void pressTitleBarButton(String buttonText) {
        WebElement titleBarButton = basicDriver.findElementByXpath(String.format(titleBarButtonXpath, buttonText));
        basicDriver.click(titleBarButton);
    }


    public void checkAddressee(String expectedAddressee) {
        WebElement addressee = basicDriver.findElementByXpath(checkAddresseeXpath);
        Assert.assertEquals(addressee.getText(), expectedAddressee);
    }


    public void checkSubjectBox() {
        WebElement subjectBox = basicDriver.findElementByXpath(checkSubjectBoxXpath);
        Assert.assertEquals(subjectBox.getAttribute("value"), randomBodyText);
    }


    public void checkLetterBody(String expectedLetterBody){
        WebElement letterBody = basicDriver.findElementByXpath(checkLetterBodyXpath);
        Assert.assertEquals(letterBody.getText(), expectedLetterBody);
    }


    public void clickButtonInLetterWindow(String buttonLabel) {
        WebElement letterWindowButton = basicDriver.findElementByXpath(String.format(letterWindowButtonXpath,
                buttonLabel));
        basicDriver.click(letterWindowButton);
    }

}
