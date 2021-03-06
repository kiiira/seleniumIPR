package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils {


    public static ThreadLocal<String> generatedWord = new ThreadLocal<>();


    /**
     * Generates random words
     *
     * @return random word
     */
    private static void wordGenerator() {
        String alphaNumericString = "0123456789"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = (int) (alphaNumericString.length()
                    * Math.random());
            stringBuilder.append(alphaNumericString.charAt(index));
        }
        generatedWord.set(stringBuilder.toString());
    }

    public static String getGeneratedWord() {
        if (generatedWord.get() == null) {
            wordGenerator();
        }
        return generatedWord.get();
    }

    public static String readProperties(String key) throws IOException {
        FileReader reader = new FileReader("system.properties");
        Properties properties = new Properties();
        properties.load(reader);
        return properties.getProperty(key);
    }
}