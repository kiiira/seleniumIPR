package PageObject;


public class MainPage extends BasicPage {


    private String identifierIconXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String accountActionButtonXpath = "//a[contains(text(), 'Выйти')]";


    public void clickAccountButton(){
        basicDriver.findElementByXpath(identifierIconXpath).click();
    }


    public void clickAccountActionButton(String buttonLabel){
        basicDriver.findElementByXpath(accountActionButtonXpath).click();
    }

}
