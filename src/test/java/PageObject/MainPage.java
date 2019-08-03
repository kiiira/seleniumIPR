package PageObject;


public class MainPage extends BasicPage {


    private String identifierIconXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String accountActionButtonXpath = "//a[contains(text(), 'Выйти')]";


    public void clickAccountButton(){
        driver.findElementByXpath(identifierIconXpath).click();
    }


    public void clickAccountActionButton(String buttonLabel){
        driver.findElementByXpath(accountActionButtonXpath).click();
    }

}
