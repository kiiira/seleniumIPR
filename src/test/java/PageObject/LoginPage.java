package PageObject;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {

    private String nextButtonXpath = "//span[contains(text(), '%s')]";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";


    public void pressButton(String fieldName) {
        WebElement section = driver.findElementByXpath(String.format(nextButtonXpath, fieldName));
        driver.click(section);
    }


    public void fillEmailFieldWithValue(String value){
        WebElement emailInputField = driver.findElementByCssSelector(emailCss);
        driver.input(emailInputField, value);
    }


    public void fillPasswordFieldWithValue(String value){
        WebElement passInputField = driver.findElementByCssSelector(passCss);
        driver.input(passInputField, value);
    }

}
