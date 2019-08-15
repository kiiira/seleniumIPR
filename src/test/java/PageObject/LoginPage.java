package PageObject;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {


    private String nextButtonXpath = "//span[contains(text(), '%s')]";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";

    public void pressButton(String fieldName) {
        WebElement section = basicDriver.findElementByXpath(String.format(nextButtonXpath, fieldName));
        basicDriver.click(section);
    }


    public void fillEmailFieldWithValue(String value){
        WebElement emailInputField = basicDriver.findElementByCssSelector(emailCss);
        basicDriver.input(emailInputField, value);
    }


    public void fillPasswordFieldWithValue(String value){
        WebElement passInputField = basicDriver.findElementByCssSelector(passCss);
        basicDriver.input(passInputField, value);
    }

}
