package PageObject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Utils.HelpfulShizzle.wordGenerator;

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
        WebElement textAreaElement = webDriver.findElementByXpath(String.format(textAreaFieldXpath, fieldName));
        webDriver.input(textAreaElement, value);
    }


    public void fillInputElementWithRandomValue(String fieldName) {
        WebElement inputElement = webDriver.findElementByXpath(String.format(inputFieldXpath, fieldName));
        randomBodyText = wordGenerator();
        webDriver.input(inputElement, randomBodyText);
    }


    public void fillDivTextFieldWithValue(String fieldName, String value) {
        WebElement divTextFieldElement = webDriver.findElementByXpath(String.format(divTextFieldXpath, fieldName));
        webDriver.input(divTextFieldElement, value);
    }


    public void pressTitleBarButton(String buttonText) {
        WebElement titleBarButton = webDriver.findElementByXpath(String.format(titleBarButtonXpath, buttonText));
        webDriver.click(titleBarButton);
    }


    public void checkAddressee(String expectedAddressee) {
        WebElement addressee = webDriver.findElementByXpath(checkAddresseeXpath);
        Assert.assertEquals(addressee.getText(), expectedAddressee);
    }


    public void checkSubjectBox() {
        WebElement subjectBox = webDriver.findElementByXpath(checkSubjectBoxXpath);
        Assert.assertEquals(subjectBox.getAttribute("value"), randomBodyText);
    }


    public void checkLetterBody(String expectedLetterBody){
        WebElement letterBody = webDriver.findElementByXpath(checkLetterBodyXpath);
        Assert.assertEquals(letterBody.getText(), expectedLetterBody);
    }


    public void clickButtonInLetterWindow(String buttonLabel) {
        WebElement letterWindowButton = webDriver.findElementByXpath(String.format(letterWindowButtonXpath,
                buttonLabel));
        webDriver.click(letterWindowButton);
    }

}
