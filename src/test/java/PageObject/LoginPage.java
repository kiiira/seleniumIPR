package PageObject;

import Config.Utils;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasicPage {

    private String nextButtonXpath = "//span[text()='Далее']";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";


    public void pressButton(String fieldName) {
        WebElement section = basicDriver.get().findElementByXpath(String.format(nextButtonXpath, fieldName));
        basicDriver.get().click(section);
    }


    public void fillEmailFieldWithValue() throws IOException {
        WebElement emailInputField = basicDriver.get().findElementByCssSelector(emailCss);
        basicDriver.get().input(emailInputField, Utils.readLoginProperties("login"));
    }


    public void fillPasswordFieldWithValue() throws IOException {
        WebElement passInputField = basicDriver.get().findElementByCssSelector(passCss);
        basicDriver.get().input(passInputField, Utils.readLoginProperties("pass"));
    }

}
