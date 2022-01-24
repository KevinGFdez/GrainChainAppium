package screens.home;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.base.BaseScreen;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(id = "io.grainchain.logintest:id/toolbar")
    MobileElement titleToolbar;

    @AndroidFindBy(id = "io.grainchain.logintest:id/textview_first")
    MobileElement userNameLabel;


    public boolean isTitleDisplayed() {
        return isDisplayed(titleToolbar);
    }

    public String getUserNameLabel(){
        return getText(userNameLabel);
    }




}
