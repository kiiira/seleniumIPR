package PageObject;

import Run.BasicDriver;
import Run.CustomChromeDriver;
import Run.CustomFirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class BasicPage {

    private static final Logger LOG = LogManager.getLogger(BasicPage.class);

    protected static ThreadLocal<BasicDriver> basicDriver = new ThreadLocal<>();

    public static void setUp(String browserName) {
        if (browserName.equals("chrome")) {
            basicDriver.set(CustomChromeDriver.getInstance());
        } else if (browserName.equals("firefox")) {
            basicDriver.set(CustomFirefoxDriver.getInstance());
        }

        LOG.info("Set up " + browserName + " browser.");
        LOG.info("Thread id is " + Thread.currentThread().getId());
    }


    public void navigate(String url) {
        basicDriver.get().get(url);
    }


    public static void shutDown() {
        basicDriver.get().quit();
    }

    String readLoginProperties(String key) throws IOException {
        FileReader reader = new FileReader("login.properties");
        Properties properties = new Properties();
        properties.load(reader);
        return properties.getProperty(key);
    }


}
