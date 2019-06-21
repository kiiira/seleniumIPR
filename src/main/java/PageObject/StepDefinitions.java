package PageObject;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class StepDefinitions {


    //TODO: add different words to string builder

    private MainPage mainPage = new MainPage();
    private MailPage mailPage = new MailPage();
    private BasicPage basicPage = new MainPage();

    private final Logger log = Logger.getLogger(Logger.class);

    private String testHost = "https://www.google.com/gmail/";


    @Step("Opening test host...")
    @Given("test host open")
    public void openHost() {
        basicPage.navigateTo(this.testHost);
        log.info("Test host opened");
    }


    @Step("Filling e-mail field with value \"{0}\"")
    @And("^fill e-mail field with value \"([^\"]*)\"$")
    public void fillEMailFieldWithValue(String value) {
        mainPage.fillEmailFieldWithValue(value);
        log.info(String.format("E-mail field filled with value %s", value));
    }


    @Step("Filling password field with value \"{0}\"")
    @And("^fill password field with value \"([^\"]*)\"$")
    public void fillPasswordFieldWithValue(String value) {
        mainPage.fillPasswordFieldWithValue(value);
        log.info(String.format("Password field filled with value %s", value));
    }


    @Step("Pressing \"{0}\" button")
    @And("^press \"([^\"]*)\" button$")
    public void pressButton(String buttonLabel) {
        mainPage.pressButton(buttonLabel);
    }


    @Step("Click div button {0}")
    @And("^click \"([^\"]*)\" div button$")
    public void clickDivButton(String divButtonLabel) {
        mailPage.clickDivButton(divButtonLabel);
    }


    @And("^fill \"([^\"]*)\" addressee field with value \"([^\"]*)\"$")
    public void fillTextAreaFieldWithValue(String fieldLabel, String value) {
        mailPage.fillTextAreaElementWithValue(fieldLabel, value);
    }


    @And("^fill \"([^\"]*)\" subject field with value \"([^\"]*)\"$")
    public void fillInputFieldValue(String fieldLabel, String value) {
        mailPage.fillInputElementWithValue(fieldLabel, value);
    }


    @And("^fill \"([^\"]*)\" text field with random value$")
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


    @And("^press \"([^\"]*)\" button after identifier$")
    public void pressButtonAfterIdentifier(String arg0) {
    }

    @And("^press Next button after password$")
    public void pressNextButtonAfterPassword() {
    }

}
