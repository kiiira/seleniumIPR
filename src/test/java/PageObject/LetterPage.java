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


    public void fillTextAreaElementWithValue(String fieldName, String value) {
        WebElement textAreaElement = driver.findElementByXpath(String.format(textAreaFieldXpath, fieldName));
        driver.input(textAreaElement, value);
    }


    public void fillInputElementWithRandomValue(String fieldName) {
        WebElement inputElement = driver.findElementByXpath(String.format(inputFieldXpath, fieldName));
        randomBodyText = wordGenerator();
        driver.input(inputElement, randomBodyText);
    }


    public void fillDivTextFieldWithValue(String fieldName, String value) {
        WebElement divTextFieldElement = driver.findElementByXpath(String.format(divTextFieldXpath, fieldName));
        driver.input(divTextFieldElement, value);
    }


    public void pressTitleBarButton(String buttonText) {
        WebElement titleBarButton = driver.findElementByXpath(String.format(titleBarButtonXpath, buttonText));
        driver.click(titleBarButton);
    }


    public void checkAddressee(String expectedAddressee) {
        WebElement addressee = driver.findElementByXpath(checkAddresseeXpath);
        Assert.assertEquals(addressee.getText(), expectedAddressee);
    }


    public void checkSubjectBox() {
        WebElement subjectBox = driver.findElementByXpath(checkSubjectBoxXpath);
        Assert.assertEquals(subjectBox.getAttribute("value"), randomBodyText);
    }


    public void checkLetterBody(String expectedLetterBody){
        WebElement letterBody = driver.findElementByXpath(checkLetterBodyXpath);
        Assert.assertEquals(letterBody.getText(), expectedLetterBody);
    }


    public void clickButtonInLetterWindow(String buttonLabel) {
        WebElement letterWindowButton = driver.findElementByXpath(String.format(letterWindowButtonXpath,
                buttonLabel));
        driver.click(letterWindowButton);
    }

}
