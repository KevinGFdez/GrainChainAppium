package runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import utils.cucumber.runner.BaseRunner;

@CucumberOptions(
        tags= "@Login"
)

public class AndroidRunner extends BaseRunner {

    @BeforeSuite
    public void setUp() {
        //Local
        deviceUdid="emulator-5554";
        deviceName="Nexus11";
        appPath= "";
    }
}
