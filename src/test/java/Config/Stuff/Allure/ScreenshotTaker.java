package Config.Stuff.Allure;

import io.qameta.allure.Allure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Utils.CustomDriver.getScreenshot;

public class ScreenshotTaker {
    public static void attachScreenshot() {
        Allure.getLifecycle().addAttachment(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
                "image/png",
                "png",
                getScreenshot()
        );
    }
}
