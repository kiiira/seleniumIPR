package Config.Utilities;

import io.qameta.allure.cucumberjvm.AllureCucumberJvm;

public class AllureLifecycle extends AllureCucumberJvm {

    @Override
    public void result(gherkin.formatter.model.Result result) {
        if (result.getStatus().equals("passed") && (result.getStatus().equals("skipped"))
                && (result.getStatus().equals("failed"))) {
//            screenshot();
        }
        super.result(result);
    }

//    @Attachment(type = "image/jpeg", value = "Screenshot on step")
//    byte[] screenshot() {
////        return ((TakesScreenshot) StepDefinitions.getChromeDriver().getScreenshotAs(OutputType.BYTES);
//    }
}

