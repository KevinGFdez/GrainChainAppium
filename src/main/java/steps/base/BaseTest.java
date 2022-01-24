package steps.base;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import utils.appium.AppiumDriverManager;
import utils.cucumber.report.CucumberReport;
import utils.data.DataManager;
import utils.properties.PropertiesManager;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    //Appium
    public static AppiumDriver getDriver(){
        return AppiumDriverManager.getDriver();
    }
    public static void setUpDriver() throws MalformedURLException {
        AppiumDriverManager.setUpDriver();
    }
    public static void quitDriver(){
        AppiumDriverManager.quitDriver();
    }
    public static void startRecording(){
        AppiumDriverManager.startRecording();
    }
    public static void stopRecording(String scenarioName, String scenarioStatus) throws IOException {
        AppiumDriverManager.stopRecording(scenarioName,scenarioStatus);
    }
    public static byte[] takeScreenshot(){
        return AppiumDriverManager.takeScreenshot();
    }
    //Cucumber
    public static void setScenario(Scenario scenario){
        CucumberReport.setScenario(scenario);
    }
    public static void attachScreenshotToReport(){
        CucumberReport.attachScreenshotToReport(takeScreenshot());
    }
    public static void attachTextToReport(String text, String name){
        CucumberReport.attachTextToReport(text,name);
    }
    //Data
    public static String getRandomEmail(){
        return DataManager.getRandomEmail();
    }
    public static String getRandomNumber(int digits){
        return DataManager.getRandomNumber(digits);
    }

    //Properties
    public static String getNodePath() {
        return PropertiesManager.getNodePath();
    }
    public static String getAppiumPath() {
        return PropertiesManager.getAppiumPath();
    }
    public static boolean getAlwaysRecord(){
        return PropertiesManager.getAlwaysRecord();
    }
}
