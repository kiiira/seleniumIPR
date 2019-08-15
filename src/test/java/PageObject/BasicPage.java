package PageObject;

import Run.BasicDriver;

public abstract class BasicPage {


    public BasicDriver basicDriver;


    public void navigate(String url) {
        basicDriver.get(url);
    }


    public void shutDown(){
        basicDriver.close();
    }


}
