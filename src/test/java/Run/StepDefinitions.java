package Run;

import PageObject.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class StepDefinitions {


    //TODO: add different words to string builder
    //TODO: add logger appenders

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private MailPage mailPage = new MailPage();
    private LetterPage letterPage = new LetterPage();
    private BasicPage basicPage = new MainPage();

    private final Logger log = Logger.getLogger(Logger.class);

    private String testHost = "https://www.google.com/gmail/";


    @Given("test host open")
    public void openHost() {
        basicPage.navigateTo(this.testHost);
        log.info("Test host opened");
    }


    @And("^fill e-mail field with value \"([^\"]*)\"$")
    public void fillEMailFieldWithValue(String value) {
        loginPage.fillEmailFieldWithValue(value);
        log.info(String.format("E-mail field filled with value %s", value));
    }


    @And("^fill password field with value \"([^\"]*)\"$")
    public void fillPasswordFieldWithValue(String value) {
        loginPage.fillPasswordFieldWithValue(value);
        log.info(String.format("Password field filled with value %s", value));
    }


    @And("^press \"([^\"]*)\" button$")
    public void pressButton(String buttonLabel) {
        loginPage.pressButton(buttonLabel);
        log.info("");
    }


    @And("^click \"([^\"]*)\" div button$")
    public void clickDivButton(String divButtonLabel) {
        mailPage.clickDivButton(divButtonLabel);
        log.info("");
    }


    @And("^fill \"([^\"]*)\" addressee field with value \"([^\"]*)\"$")
    public void fillTextAreaFieldWithValue(String fieldLabel, String value) {
        letterPage.fillTextAreaElementWithValue(fieldLabel, value);
        log.info("");
    }


    @And("^fill \"([^\"]*)\" subject field with random value$")
    public void fillInputFieldValue(String fieldLabel) {
        letterPage.fillInputElementWithRandomValue(fieldLabel);
        log.info("");
    }


    @And("^fill \"([^\"]*)\" text field with value \"([^\"]*)\"$")
    public void fillDivTextFieldWithRandomValue(String fieldLabel, String inputText) {
        letterPage.fillDivTextFieldWithValue(fieldLabel, inputText);
        log.info("");
    }


    @And("^click \"([^\"]*)\" button in letter title bar$")
    public void clickButtonInLetterTitleBar(String button) {
        letterPage.pressTitleBarButton(button);
        log.info("");
    }


    @And("^go to \"([^\"]*)\" folder$")
    public void goToFolder(String folderLabel) {
        mailPage.openFolder(folderLabel);
        log.info("");
    }


    @And("^the letter has been created$")
    public void checkLetterCreated() {
        mailPage.checkLetterCreated();
        log.info("");
    }


    @And("^open the template$")
    public void openTheTemplate() {
        mailPage.openTemplate();
        log.info("");
    }


    @And("^the template has addressee field as \"([^\"]*)\"$")
    public void checkTemplateAddressee(String value) {
        letterPage.checkAddressee(value);
    }


    @And("^the template has subject field as randomly generated text$")
    public void checkTemplateSubject(String value) {
        letterPage.checkSubjectBox(value);
    }


    @And("^the template has body field as \"([^\"]*)\"$")
    public void checkTemplateBody() {
        letterPage.checkLetterBody();
    }


    @And("^press \"([^\"]*)\" button in letter window$")
    public void pressButtonInLetterWindow(String buttonLabel) {
        letterPage.clickButtonInLetterWindow(buttonLabel);
    }


    @Then("^the template has been deleted$")
    public void theTemplateHasBeenDeleted() {
        mailPage.checkTemplateDeleted();
    }


    @And("^press account button$")
    public void pressAccountButton() {
        mainPage.clickAccountButton();
    }


    @And("^press \"([^\"]*)\" button in account popup$")
    public void pressButtonInAccountPopup(String buttonLabel) {
        mainPage.clickAccountActionButton(buttonLabel);
    }
}
