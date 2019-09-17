package PageObject;

import Config.Utils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SentLettersPage extends BasicPage {


    private String lettersXpath = "//div[contains(text(), 'Кому: ')]//ancestor::div[@role='main']" +
            "//div[@role='link']//span[@data-thread-id]";


    public void checkLetterCreated() {
        List<WebElement> templates = basicDriver.get().findElementListByXpath((lettersXpath));
        WebElement template = templates.stream().findFirst().get();
        Assert.assertEquals(template.getText(), Utils.getGeneratedWord(), "The element with given parameters wasn't found.");

    }

}
