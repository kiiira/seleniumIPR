package PageObject;

import org.openqa.selenium.WebElement;


public class MainPage extends BasicPage {


    String sectionXpath = "";

    /**
     * Opens section
     *
     * @param sectionName section text label
     */
    public void openSection(String sectionName) {
        String testLink = String.format(sectionXpath, sectionName);
        WebElement section = webDriver.findElementByXpath(testLink);
        webDriver.click(section);
    }
}
