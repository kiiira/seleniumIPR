package Run;

import PageObject.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static PageObject.LetterPage.randomBodyText;

public class StepDefinitions {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private MailPage mailPage = new MailPage();
    private LetterPage letterPage = new LetterPage();
    private BasicPage basicPage = new MainPage();

    private static final Logger LOG = LogManager.getLogger(StepDefinitions.class);

    private String testHost = "https://www.google.com/gmail/";


    @Step ("Opening test host")
    @Given("test host open")
    public void openHost() {
        basicPage.navigate(this.testHost);
        LOG.debug("Test host opened");
    }


    @Step("Filling email field with value \"{0}\"")
    @And("^fill e-mail field with value \"([^\"]*)\"$")
    public void fillEMailFieldWithValue(String value) {
        loginPage.fillEmailFieldWithValue(value);
        LOG.info(String.format("E-mail field filled with value %s", value));
    }

    @Step("Filling password field with value \"{0}\"")
    @And("^fill password field with value \"([^\"]*)\"$")
    public void fillPasswordFieldWithValue(String value) {
        loginPage.fillPasswordFieldWithValue(value);
        LOG.info(String.format("Password field filled with value %s", value));
    }


    @And("^press \"([^\"]*)\" button$")
    public void pressButton(String buttonLabel) {
        loginPage.pressButton(buttonLabel);
        LOG.info(String.format("\"%s\" button pressed", buttonLabel));
    }


    @And("^click \"([^\"]*)\" div button$")
    public void clickDivButton(String divButtonLabel) {
        mailPage.clickDivButton(divButtonLabel);
        LOG.info(String.format("\"%s\" div button pressed", divButtonLabel));
    }


    @And("^fill \"([^\"]*)\" addressee field with value \"([^\"]*)\"$")
    public void fillTextAreaFieldWithValue(String fieldLabel, String value) {
        letterPage.fillTextAreaElementWithValue(fieldLabel, value);
        LOG.info(String.format("Text area \"%s\" filled with value \"%s\"", fieldLabel, value));
    }


    @And("^fill \"([^\"]*)\" subject field with random value$")
    public void fillInputFieldValue(String fieldLabel) {
        letterPage.fillInputElementWithRandomValue(fieldLabel);
        LOG.info(String.format("Input fields filled with value \"%s\"", fieldLabel));
    }


    @And("^fill \"([^\"]*)\" text field with value \"([^\"]*)\"$")
    public void fillDivTextFieldWithRandomValue(String fieldLabel, String inputText) {
        letterPage.fillDivTextFieldWithValue(fieldLabel, inputText);
        LOG.info(String.format("Div text field \"%s\" filled with value \"%s\"", fieldLabel, inputText));
    }


    @And("^click \"([^\"]*)\" button in letter title bar$")
    public void clickButtonInLetterTitleBar(String button) {
        letterPage.pressTitleBarButton(button);
        LOG.info(String.format("\"%s\" button clicked in letter title bar", button));
    }


    @And("^go to \"([^\"]*)\" folder$")
    public void goToFolder(String folderLabel) {
        mailPage.openFolder(folderLabel);
        LOG.info(String.format("Navigating to folder \"%s\"", folderLabel));
    }


    @And("^the letter has been created$")
    public void checkLetterCreated() {
        mailPage.checkLetterCreated();
        LOG.info("Congratulations! The letter has been created");
    }


    @And("^open the template$")
    public void openTheTemplate() {
        mailPage.openTemplate();
        LOG.info("Opening the newly created template");
    }


    @And("^the template has addressee field as \"([^\"]*)\"$")
    public void checkTemplateAddressee(String value) {
        letterPage.checkAddressee(value);
        LOG.info(String.format("The template has expected addressee field \"%s\"", value));
    }


    @And("^the template has subject field as randomly generated text$")
    public void checkTemplateSubject() {
        letterPage.checkSubjectBox();
        LOG.info(String.format("The template has subject field as randomly generated text: \"%s\"", randomBodyText));
    }


    @And("^the template has body field as \"([^\"]*)\"$")
    public void checkTemplateBody(String expectedLetterBody) {
        letterPage.checkLetterBody(expectedLetterBody);
        LOG.info(String.format("The template has body field as \"%s\"", expectedLetterBody));
    }


    @And("^press \"([^\"]*)\" button in letter window$")
    public void pressButtonInLetterWindow(String buttonLabel) {
        letterPage.clickButtonInLetterWindow(buttonLabel);
        LOG.info(String.format("Pressing \"%s\" button in letter window", buttonLabel));
    }


    @Then("^the template has been deleted$")
    public void theTemplateHasBeenDeleted() {
        mailPage.checkTemplateDeleted();
        LOG.info("The template has been successfully deleted");
    }


    @And("^press account button$")
    public void pressAccountButton() {
        mainPage.clickAccountButton();
        LOG.info("Pressing account button");
    }


    @And("^press \"([^\"]*)\" button in account popup$")
    public void pressButtonInAccountPopup(String buttonLabel) {
        mainPage.clickAccountActionButton(buttonLabel);
        LOG.info(String.format("Pressing \"%s\" button in account popup", buttonLabel));
    }
}
