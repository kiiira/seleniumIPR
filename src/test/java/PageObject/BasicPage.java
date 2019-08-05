package PageObject;

import Run.BasicDriver;

public abstract class BasicPage {


    /**
     * Driver instantiation
     */
    BasicDriver driver = BasicDriver.getInstance();


    /**
     * Selenium "get" method wrapper
     *
     * @param url to navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }


}
