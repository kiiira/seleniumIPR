package PageObject;

import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class StepDefinitions {

    private MainPage mainPage = new MainPage();
    private BasicPage basicPage = new MainPage();

    private final Logger log = Logger.getLogger(Logger.class);

    String testHost = "https://mail.ru";

    @Step("Открытие тестового хоста")
    @Given("test host open")
    public void openHost() {
        basicPage.navigateTo(this.testHost);
        log.debug("Открытие тестового хоста");
    }


    @Step("Нажатие раздела \"{0}\"}")
    @Given("^press link \"([^\"]*)\"$")
    public void pressLink(String section) {
        mainPage.openSection(section);
        log.debug(String.format("Открыт раздел \"%s\"", section));
    }


//    @Then("Page {string} opened")
//    public void page_opened(String string) {
//    }


}
