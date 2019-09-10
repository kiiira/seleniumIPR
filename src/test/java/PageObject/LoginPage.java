package PageObject;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {


    private String nextButtonXpath = "//span[contains(text(), '%s')]";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";


    public void pressButton(String fieldName) {
        WebElement section = basicDriver.get().findElementByXpath(String.format(nextButtonXpath, fieldName));
        basicDriver.get().click(section);
    }


    public void fillEmailFieldWithValue(String value) {
        WebElement emailInputField = basicDriver.get().findElementByCssSelector(emailCss);
        basicDriver.get().input(emailInputField, value);
    }


    public void fillPasswordFieldWithValue(String value) {
        WebElement passInputField = basicDriver.get().findElementByCssSelector(passCss);
        basicDriver.get().input(passInputField, value);
    }

}
