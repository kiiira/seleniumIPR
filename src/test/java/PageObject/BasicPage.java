package PageObject;

import Run.BasicDriver;
import Run.CustomChromeDriver;
import Run.CustomFirefoxDriver;
import Run.StepDefinitions;


public abstract class BasicPage {


    public BasicDriver basicDriver;


    /**
     * Using driver instance depending on parameter called in BeforeTest
     *
     * @param browserName browser to instantiate
     */
    public BasicPage(String browserName) {
        if (browserName.equalsIgnoreCase(StepDefinitions.getBrowser())) {
            CustomChromeDriver basicDriver = CustomChromeDriver.getInstance();

        } else if (browserName.equalsIgnoreCase(StepDefinitions.getBrowser())) {
            CustomFirefoxDriver basicDriver = CustomFirefoxDriver.getInstance();
        }
    }


    public void navigate(String url) {
        basicDriver.get(url);
    }


    public void shutDown(){
        basicDriver.close();
    }


}
