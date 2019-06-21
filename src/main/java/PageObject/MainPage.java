package PageObject;

import org.openqa.selenium.WebElement;


public class MainPage extends BasicPage {


    private String nextButtonXpath = "#identifierNext";
    private String inputFieldXpath = "#%s";


    /**
     * Clicks span-type button
     *
     * @param buttonLabel button text label
     */

    //TODO: fix gherkin
    //TODO: add different words to string builder
    public void pressNextButton(String buttonLabel) {
        WebElement section = webDriver.findElementByXpath(String.format(nextButtonXpath, buttonLabel));
        webDriver.click(section);
    }

    /**
     *
     * @param field
     * @param value
     */
    public void fillInputFieldWithValue(String field, String value){
        WebElement inputField = webDriver.findElementByCssSelector(String.format(inputFieldXpath, field));
        webDriver.input(inputField, value);
    }

}
