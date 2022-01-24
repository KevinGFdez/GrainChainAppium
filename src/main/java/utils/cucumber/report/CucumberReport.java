package utils.cucumber.report;

import io.cucumber.java.Scenario;

public class CucumberReport {
    private static ThreadLocal<Scenario>  scenario = new ThreadLocal<>();

    public static void setScenario(Scenario newScenario){
        scenario.set(newScenario);
    }
    public static Scenario getScenario(){
        return scenario.get();
    }

    public static void attachScreenshotToReport(byte[] screenshot){
        if (getScenario() != null) {
            getScenario().attach(screenshot, "image/png", getScenario().getName());
        }
    }

    public static void attachTextToReport(String text, String name){
        if (getScenario() != null) getScenario().attach(text,"text/plain",name);
    }

}
