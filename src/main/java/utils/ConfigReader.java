package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static String getProperty(String key) {
        try {
            if (prop == null) {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}