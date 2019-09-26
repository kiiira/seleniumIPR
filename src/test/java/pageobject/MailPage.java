package pageobject;

import org.openqa.selenium.WebElement;

public class MailPage extends BasicPage {


    private String divButtonXpath = "//div[@role='button' and text()='%s']";
    private String folderXpath = "//a[@title='%s']";


    public void clickDivButton(String buttonText) {
        WebElement divButton = basicDriver.get().findElementByXpath(String.format(divButtonXpath, buttonText));
        basicDriver.get().click(divButton);
    }


    public void openFolder(String folderLabel) {
        WebElement section = basicDriver.get().findElementByXpath(String.format(folderXpath, folderLabel));
        basicDriver.get().click(section);
    }

}