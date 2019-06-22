package PageObject;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import jdk.jfr.StackTrace;
import org.apache.log4j.Logger;

public class StepDefinitions {


    //TODO: add different words to string builder
    //TODO: add logger appenders

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
        log.info("");
    }


    @Step("Click div button {0}")
    @And("^click \"([^\"]*)\" div button$")
    public void clickDivButton(String divButtonLabel) {
        mailPage.clickDivButton(divButtonLabel);
        log.info("");
    }


    @Step("Filling \"{0}]\" addressee field with value \"{1}\"")
    @And("^fill \"([^\"]*)\" addressee field with value \"([^\"]*)\"$")
    public void fillTextAreaFieldWithValue(String fieldLabel, String value) {
        mailPage.fillTextAreaElementWithValue(fieldLabel, value);
        log.info("");
    }


    @Step("Filling \"{0}\" subject field with value \"{1}\"")
    @And("^fill \"([^\"]*)\" subject field with value \"([^\"]*)\"$")
    public void fillInputFieldValue(String fieldLabel, String value) {
        mailPage.fillInputElementWithValue(fieldLabel, value);
        log.info("");
    }


    @Step("Filling \"{0}\" text field with random value")
    @And("^fill \"([^\"]*)\" text field with random value$")
    public void fillDivTextFieldWithRandomValue(String fieldLabel) {
        mailPage.fillDivTextFieldWithRandomValue(fieldLabel);
        log.info("");
    }


    @Step("Clicking \"{0}\" button in letter title bar")
    @And("^click \"([^\"]*)\" button in letter title bar$")
    public void clickButtonInLetterTitleBar(String button) {
        mailPage.pressTitleBarButton(button);
        log.info("");
    }


    @Step("Navigating to \"{0}\" folder")
    @And("^go to \"([^\"]*)\" folder$")
    public void goToFolder(String folderLabel) {
        mailPage.openFolder(folderLabel);
        log.info("");
    }


    @Step("Checking template has been created")
    @And("^the letter has been created$")
    public void checkLetterCreated() {
        mailPage.checkLetterCreated();
        log.info("");
    }


    @Step("Opening the letter template")
    @And("^open the template$")
    public void openTheTemplate() {
        mailPage.openTemplate();
        log.info("");
    }


    @Step("Checking whether addressee field has value \"{1}\"")
    @And("^the template has addressee field as \"([^\"]*)\"$")
    public void checkTemplateAddressee(String value) {
        mailPage.checkAddressee(value);
    }


    @Step("Checking whether subject field has value \"{1}\"")
    @And("^the template has subject field as \"([^\"]*)\"$")
    public void checkTemplateSubject(String value) {
        mailPage.checkSubjectBox(value);
    }


    @Step("Checking whether body field has value as randomly generated text")
    @And("^the template has body field as randomly generated text$")
    public void checkTemplateBody() {
        mailPage.checkLetterBody();
    }


    @Step("Clicking \"{0}\" button in letter window")
    @And("^press \"([^\"]*)\" button in letter window$")
    public void pressButtonInLetterWindow(String buttonLabel) {
        mailPage.clickButtonInLetterWindow(buttonLabel);
    }


    @Step("Checking template deleted")
    @Then("^the template has been deleted$")
    public void theTemplateHasBeenDeleted() {
        mailPage.checkTemplateDeleted();
    }


    @Step("Clicking account button")
    @And("^press account button$")
    public void pressAccountButton() {
        mainPage.clickAccountButton();
    }


    @Step("Clicking \"{0}\" button in account pop-up")
    @And("^press \"([^\"]*)\" button in account popup$")
    public void pressButtonInAccountPopup(String buttonLabel) {
        mainPage.clickAccountActionButton(buttonLabel);
    }
}
