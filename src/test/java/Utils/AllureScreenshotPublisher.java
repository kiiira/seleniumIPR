package Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Utils.CustomDriver.customDriver;

public class AllureScreenshotPublisher implements StepLifecycleListener {

    @Override
    public void afterStepUpdate(StepResult result) {
        attachScreenshot();
    }

    public static void attachScreenshot() {
        Allure.getLifecycle().addAttachment(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
                "image/png",
                "png",
                getScreenshot()
        );
    }

    private static byte[] getScreenshot() {
        return (((TakesScreenshot) customDriver).getScreenshotAs(OutputType.BYTES));
    }


}

