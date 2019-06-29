package Config;

import org.aeonbits.owner.Config;

@Config.Sources("file:config.properties")
public interface ProjectConfigurations extends Config{

    String testHost();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("false")
    boolean remoteBrowser();

    @DefaultValue("true")
    boolean maximizeBrowser();

    @DefaultValue("test/resources/features")
    String testDataDirectory();

    @DefaultValue("true")
    boolean takeScreenshot();

}
