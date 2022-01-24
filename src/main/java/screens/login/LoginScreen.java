package screens.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.base.BaseScreen;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(id = "io.grainchain.logintest:id/username")
    MobileElement emailField;

    @AndroidFindBy(id = "io.grainchain.logintest:id/password")
    MobileElement passwordField;

    @AndroidFindBy(id = "io.grainchain.logintest:id/login")
    MobileElement loginButton;


    public void enterEmail(String email){
        enter(emailField,email);
    }

    public void enterPassword(String password){
        enter(passwordField,password);
    }

    public void typePassword(String password){
        type(passwordField,password);
        hideKeyboard();
    }

    public void tapLoginButton(){
        tap(loginButton);
    }

    public boolean isLoginButtonEnabled(){
        return isEnabled(loginButton);
    }

}
