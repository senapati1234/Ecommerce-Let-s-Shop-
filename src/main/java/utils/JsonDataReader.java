/*
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
}*/
package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonDataReader {

    public static TestData getTestData() {
        ObjectMapper mapper = new ObjectMapper();
        TestData data = null;
        try {
            data = mapper.readValue(new File("src/test/resources/testdata.json"), TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
