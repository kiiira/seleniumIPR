package PageObject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Config.Stuff.HelpfulShizzle.wordGenerator;

/**
 * Letter popup page.
 */
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


    public void fillTextAreaElementWithValue(String fieldName, String value) {
        WebElement textAreaElement = basicDriver.get().findElementByXpath(String.format(textAreaFieldXpath, fieldName));
        basicDriver.get().input(textAreaElement, value);
    }


    public void fillInputElementWithRandomValue(String fieldName) {
        WebElement inputElement = basicDriver.get().findElementByXpath(String.format(inputFieldXpath, fieldName));
        randomBodyText = wordGenerator();
        basicDriver.get().input(inputElement, randomBodyText);
    }


    public void fillDivTextFieldWithValue(String fieldName, String value) {
        WebElement divTextFieldElement = basicDriver.get().findElementByXpath(String.format(divTextFieldXpath, fieldName));
        basicDriver.get().input(divTextFieldElement, value);
    }


    public void pressTitleBarButton(String buttonText) {
        WebElement titleBarButton = basicDriver.get().findElementByXpath(String.format(titleBarButtonXpath, buttonText));
        basicDriver.get().click(titleBarButton);
    }


    public void checkAddressee(String expectedAddressee) {
        WebElement addressee = basicDriver.get().findElementByXpath(checkAddresseeXpath);
        Assert.assertEquals(addressee.getText(), expectedAddressee);
    }


    public void checkSubjectBox() {
        WebElement subjectBox = basicDriver.get().findElementByXpath(checkSubjectBoxXpath);
        Assert.assertEquals(subjectBox.getAttribute("value"), randomBodyText);
    }


    public void checkLetterBody(String expectedLetterBody) {
        WebElement letterBody = basicDriver.get().findElementByXpath(checkLetterBodyXpath);
        Assert.assertEquals(letterBody.getText(), expectedLetterBody);
    }


    public void clickButtonInLetterWindow(String buttonLabel) {
        WebElement letterWindowButton = basicDriver.get().findElementByXpath(String.format(letterWindowButtonXpath,
                buttonLabel));
        basicDriver.get().click(letterWindowButton);
    }

}
