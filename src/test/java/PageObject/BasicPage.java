package PageObject;

import Utils.CustomDriver;

public abstract class BasicPage {


    /**
     * Driver instantiation
     */
    CustomDriver driver = CustomDriver.getInstance();


    /**
     * Selenium "get" method wrapper
     *
     * @param url to navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }


}
