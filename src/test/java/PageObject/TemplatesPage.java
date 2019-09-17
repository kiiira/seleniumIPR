package PageObject;

import Config.Utils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class TemplatesPage extends BasicPage {


    private String templates = "//span[contains(text(), 'Черновик')]//ancestor::div[@role='main']//div[@role='link']//span[@data-thread-id]";


    public void openTemplate() {
        WebElement neededTemplate = basicDriver.get().findElementByXpath(String
                .format(templates + "[text()='%s']", Utils.getGeneratedWord()));
        basicDriver.get().click(neededTemplate);
    }


    public void checkTemplateDeleted() {
        List<WebElement> listOfTemplates = basicDriver.get().findElementListByXpath(templates);
        for (WebElement template : listOfTemplates) {
            Assert.assertNotEquals(Utils.getGeneratedWord(), template.getText());
        }
    }

}
