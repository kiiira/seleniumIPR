package Config.Utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Config.Utilities.WebDriver.webDriver;

public class AllureStepListener implements StepLifecycleListener {

    @Override
    public void afterStepUpdate(StepResult result) {
        byte[] screenShot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", screenShot);
    }
}

