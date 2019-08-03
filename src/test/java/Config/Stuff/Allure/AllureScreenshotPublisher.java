package Config.Stuff.Allure;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class AllureScreenshotPublisher implements StepLifecycleListener {

    @Override
    public void afterStepUpdate(StepResult result) {
        ScreenshotTaker.attachScreenshot();
    }

}

