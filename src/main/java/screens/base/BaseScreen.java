package screens.base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import steps.base.BaseTest;

import java.time.Duration;

public class BaseScreen {

    AppiumDriver driver;

    public BaseScreen(){
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    protected void enter(MobileElement element, String text) {
        waitToBeClickable(element);
        element.click();
        element.sendKeys(text);
        done();
    }

    protected void type(MobileElement element, String text) {
        waitToBeClickable(element);
        element.click();
        element.sendKeys(text);
    }

    protected void hideKeyboard(){
        driver.hideKeyboard();
    }

    protected boolean isEnabled(MobileElement element){
        return element.isEnabled();
    }

    protected void done() {
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
    }

    protected void tap(MobileElement element) {
        waitToBeClickable(element);
        element.click();
    }

    protected String getText(MobileElement element) {
        return (String) getWait().until(o ->{
            waitToBeVisibility(element);
            return element.getText();
        });
    }

    protected boolean isDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Waits
    protected Wait getWait(){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected void waitToBeClickable(MobileElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeVisibility(MobileElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
}
