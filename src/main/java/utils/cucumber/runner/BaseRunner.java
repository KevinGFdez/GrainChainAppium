package utils.cucumber.runner;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.appium.AppiumDriverManager;
import utils.appium.AppiumServerManager;
import utils.reports.allure.AllureManager;

@CucumberOptions(
        features= {"src/test/java/features"},
        glue= {"steps"},
        plugin={
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)

public class BaseRunner {
        protected String deviceUdid;
        protected String deviceName;
        protected String appPath;

        private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

        private static TestNGCucumberRunner getRunner(){
                return testNGCucumberRunner.get();
        }
        public static void setRunner(TestNGCucumberRunner newTestNGCucumberRunner){
                testNGCucumberRunner.set(newTestNGCucumberRunner);
        }
        @BeforeClass
        public void setUpDevice(){
                AppiumDriverManager.setDeviceFeatures(deviceUdid,deviceName,appPath);
                AppiumServerManager.startServer();
                AllureManager.setUpAllureReport(deviceName);
                setRunner(new TestNGCucumberRunner(this.getClass()));
        }

        @Test(groups = "cucumber", description= "Cucumber scenarios", dataProvider ="scenarios")
        public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature){
                getRunner().runScenario(pickle.getPickle());
        }

        @DataProvider
        public Object[][] scenarios() {
                return getRunner().provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
                AppiumServerManager.stopServer();
                getRunner().finish();
        }
}
