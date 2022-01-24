package utils.appium;

import org.openqa.selenium.remote.DesiredCapabilities;
import utils.properties.PropertiesManager;

import java.io.File;

public class CapabilitiesManager {
    private static String deviceUdid;
    private static String deviceName;
    private static String appPath;

    public static void setDeviceUdid(String newDeviceUdid) {
        deviceUdid = newDeviceUdid;
    }
    public static String getDeviceUdid(){
        return deviceUdid;
    }
    public static void setDeviceName(String newDeviceName) {
        deviceName = newDeviceName;
    }
    public static String getDeviceName(){
        return deviceName;
    }
    public static void setAppPath(String newAppPath){
        appPath = newAppPath;
    }
    public static String getAppPath(){
        return appPath;
    }
    public static String getAppPackage(){
        return PropertiesManager.getAppPackage();
    }
    public static String getAppActivity(){
        return PropertiesManager.getAppActivity();
    }

    public static DesiredCapabilities setUpAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName", getDeviceName());
        capabilities.setCapability("udid", getDeviceUdid());
        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("autoGrantPermissions", true);
        if (!getAppPath().equals("")){
            File app = new File(getAppPath());
            capabilities.setCapability("app" , app.getAbsolutePath());
        }else{
            capabilities.setCapability("appPackage", getAppPackage());
            capabilities.setCapability("appActivity", getAppActivity());
        }

        return capabilities;
    }

}
