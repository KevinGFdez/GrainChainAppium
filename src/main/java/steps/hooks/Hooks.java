package steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import steps.base.BaseTest;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends BaseTest {
    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        setUpDriver();
        setScenario(scenario);
        startRecording();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (getAlwaysRecord() || scenario.isFailed()){
            String scenarioStatus = (scenario.isFailed()) ? "Failed" : "Successful";
            stopRecording(scenario.getName(), scenarioStatus);
            attachScreenshotToReport();
        }
        quitDriver();
    }
}
