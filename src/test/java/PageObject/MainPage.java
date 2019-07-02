package PageObject;

import org.openqa.selenium.WebElement;


public class MainPage extends BasicPage {


    private String identifierIconXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String accountActionButtonXpath = "//a[contains(text(), 'Выйти')]";


    public void clickAccountButton(){
        webDriver.findElementByXpath(identifierIconXpath).click();

    }


    public void clickAccountActionButton(String buttonLabel){
        webDriver.findElementByXpath(accountActionButtonXpath).click();
    }

}
