package PageObject;


public class MainPage extends BasicPage {


    private String identifierIconXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String accountActionButtonXpath = "//a[contains(text(), 'Выйти')]";


    public void clickAccountButton(){
        basicDriver.get().findElementByXpath(identifierIconXpath).click();
    }


    public void clickAccountActionButton(String buttonLabel){
        basicDriver.get().findElementByXpath(accountActionButtonXpath).click();
    }

}
