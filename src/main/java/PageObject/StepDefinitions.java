package PageObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class StepDefinitions {

    private MainPage mainPage = new MainPage();
    private MailPage mailPage = new MailPage();
    private BasicPage basicPage = new MainPage();

    private final Logger log = Logger.getLogger(Logger.class);

    String testHost = "https://www.google.com/gmail/";

    @Step("Opening test host...")
    @Given("test host open")
    public void openHost() {
        basicPage.navigateTo(this.testHost);
        log.info("Test host opened");
    }


    @Step("Click button {0}")
    @And("^press \"([^\"]*)\" button$")
    public void pressButton(String buttonLabel) {
        mainPage.pressSpanButton(buttonLabel);
        log.info(String.format("Button \"%s\" clicked", buttonLabel));

    }

    @Step("Filling 'input' field \"{0}\" with value \"{1}\" ")
    @And("^fill \"([^\"]*)\" field with value \"([^\"]*)\"$")
    public void fillInputFieldWithValue(String fieldLabel, String textValue) {
        mainPage.fillInputFieldWithValue(fieldLabel, textValue);
        log.info(String.format("Field \"%s\" filled with value \"%s\"", fieldLabel, textValue));
    }


    @Step("Click div button {0}")
    @And("^click \"([^\"]*)\" div button$")
    public void clickDivButton(String divButtonLabel) {
        mailPage.clickDivButton(divButtonLabel);
    }


    @And("^fill \"([^\"]*)\" textarea field with value \"([^\"]*)\"$")
    public void fillTextAreaFieldWithValue(String fieldLabel, String value) {
        mailPage.fillTextAreaElementWithValue(fieldLabel, value);
    }


    @And("^fill \"([^\"]*)\" input field value \"([^\"]*)\"$")
    public void fillInputFieldValue(String fieldLabel, String value) {
        mailPage.fillInputElementWithValue(fieldLabel, value);
    }


    @And("^fill \"([^\"]*)\" div text field with random value$")
    public void fillDivTextFieldWithRandomValue(String fieldLabel) {
        mailPage.fillDivTextFieldWithRandomValue(fieldLabel);
    }


    @And("^click \"([^\"]*)\" button in letter title bar$")
    public void clickButtonInLetterTitleBar(String button) {
        mailPage.pressTitleBarButton(button);
    }


    @And("^go to \"([^\"]*)\" folder$")
    public void goToFolder(String folderLabel) {
        mailPage.openFolder(folderLabel);
    }


    @And("^check template has been created$")
    public void checkTemplateCreated() {
        mailPage.checkTemplateCreated();
    }


    @And("^open the template$")
    public void openTheTemplate() {
        mailPage.openTemplate();
    }

    @And("^the template has span field \"([^\"]*)\" as \"([^\"]*)\"$")
    public void theTemplateHasSpanFieldAs(String fieldName, String value) {

    }

    @And("^the template has input field \"([^\"]*)\" as \"([^\"]*)\"$")
    public void theTemplateHasInputFieldAs(String fieldName, String value) {

    }

    @And("^the template has div field \"([^\"]*)\" as \"([^\"]*)\"$")
    public void theTemplateHasDivFieldAs(String fieldName, String value) {


    }
}
