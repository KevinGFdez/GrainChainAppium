package utils.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void setDeviceFeatures(String deviceUdid, String deviceName, String appPath){
        CapabilitiesManager.setDeviceUdid(deviceUdid);
        CapabilitiesManager.setDeviceName(deviceName);
        CapabilitiesManager.setAppPath(appPath);
    }

    public static void setUpDriver() throws MalformedURLException {
        AppiumDriver driver = new AndroidDriver(AppiumServerManager.getServerUrl(), CapabilitiesManager.setUpAndroidCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setDriver(driver);
    }

    public static void setDriver(AppiumDriver newDriver){
        driver.set(newDriver);
    }

    public static AppiumDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        getDriver().quit();
    }

    public static String getDeviceName(){
        return CapabilitiesManager.getDeviceName();
    }

    public static void startRecording(){
        MediaManager.startRecording();
    }

    public static void stopRecording(String scenarioName,String scenarioStatus) throws IOException {
        MediaManager.stopRecording(getDriver(),scenarioName,scenarioStatus,getDeviceName());
    }

    public static byte[] takeScreenshot(){
        return MediaManager.takeScreenshot(getDriver());
    }
}
