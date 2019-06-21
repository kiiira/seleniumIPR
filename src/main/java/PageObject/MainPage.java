package PageObject;

import org.openqa.selenium.WebElement;


public class MainPage extends BasicPage {


    private String nextButtonXpath = "//span[contains(text(), '%s')]";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";


    public void pressButton(String fieldName) {
        WebElement section = webDriver.findElementByXpath(String.format(nextButtonXpath, fieldName));
        webDriver.click(section);
    }


    public void fillEmailFieldWithValue(String value){
        WebElement emailInputField = webDriver.findElementByCssSelector(emailCss);
        webDriver.input(emailInputField, value);
    }


    public void fillPasswordFieldWithValue(String value){
        WebElement passInputField = webDriver.findElementByCssSelector(passCss);
        webDriver.input(passInputField, value);
    }
}
