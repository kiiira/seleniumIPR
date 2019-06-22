package PageObject;

import org.openqa.selenium.WebElement;


public class MainPage extends BasicPage {


    private String nextButtonXpath = "//span[contains(text(), '%s')]";
    private String emailCss = "#identifierId";
    private String passCss = "#password input";
    private String identifierIconXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String accountActionButtonXpath = "//a[contains(text(), 'Выйти')]";


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


    public void clickAccountButton(){
        webDriver.findElementByXpath(identifierIconXpath).click();

    }


    public void clickAccountActionButton(String buttonLabel){
        webDriver.findElementByXpath(accountActionButtonXpath).click();
    }

}
