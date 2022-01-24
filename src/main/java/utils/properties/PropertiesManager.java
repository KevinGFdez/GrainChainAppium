package utils.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static Properties properties;

    public static void setUpProperties() {
        try {
            properties = new Properties();
            InputStream input = null;
            input = new FileInputStream("src/test/java/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getNodePath() {
        setUpProperties();
        return properties.getProperty("nodePath");
    }
    public static String getAppiumPath() {
        setUpProperties();
        return properties.getProperty("appiumPath");
    }
    public static String getAppPackage() {
        setUpProperties();
        return properties.getProperty("appPackage");
    }
    public static String getAppActivity() {
        setUpProperties();
        return properties.getProperty("appActivity");
    }
    public static boolean getAlwaysRecord() {
        setUpProperties();
        return Boolean.parseBoolean(properties.getProperty("alwaysRecord"));
    }
}
