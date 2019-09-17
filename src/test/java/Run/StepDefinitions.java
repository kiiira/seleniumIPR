package Run;

import Config.Stuff.Utils;
import PageObject.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class StepDefinitions {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private MailPage mailPage = new MailPage();
    private SentLettersPage sentLettersPage = new SentLettersPage();
    private TemplatesPage templatesPage = new TemplatesPage();
    private LetterPage letterPage = new LetterPage();
    private BasicPage basicPage = new MainPage();

    private static final Logger LOG = LogManager.getLogger(StepDefinitions.class);

    private String testHost = "https://www.google.com/gmail/";


    @Step("Opening test host")
    @Given("open test host")
    public void openHost() {
        basicPage.navigate(this.testHost);
        LOG.info("Test host opened");
    }


    @Step("Filling email field")
    @And("^fill in e-mail field$")
    public void fillEMailFieldWithValue() throws IOException {
        loginPage.fillEmailFieldWithValue();
        LOG.info("E-mail field filled");
    }

    @Step("Filling password field")
    @And("^fill in password field$")
    public void fillPasswordFieldWithValue() throws IOException {
        loginPage.fillPasswordFieldWithValue();
        LOG.info("Password field filled");
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
        sentLettersPage.checkLetterCreated();
        LOG.info("Congratulations! The letter has been created");
    }


    @And("^open the newly created template$")
    public void openTheTemplate() {
        templatesPage.openTemplate();
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
        LOG.info(String.format("The template has subject field as randomly generated text: \"%s\"", Utils.getGeneratedWord()));
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
        templatesPage.checkTemplateDeleted();
        LOG.info("The template has been successfully deleted");
    }


    @And("^press account button$")
    public void pressAccountButton() {
        mainPage.clickAccountButton();
        LOG.info("Pressing account button");
    }

    @And("^press \"([^\"]*)\" button in account popup$")
    public void pressAccountActionButton(String buttonName) {
        mainPage.clickAccountActionButton(buttonName);
        LOG.info("Pressing account button");
    }


}
