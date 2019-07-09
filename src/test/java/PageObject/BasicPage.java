package PageObject;

import Utils.WebDriver;

public abstract class BasicPage {


    /**
     * Driver instantiation
     */
    WebDriver webDriver = WebDriver.getInstance();

    public void navigateTo(String url){
        webDriver.get(url);
    }

}
