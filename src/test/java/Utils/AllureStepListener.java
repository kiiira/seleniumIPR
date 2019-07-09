package Utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static Utils.WebDriver.webDriver;

public class AllureStepListener implements StepLifecycleListener {
    @Attachment("Screenshot on failure")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

}

