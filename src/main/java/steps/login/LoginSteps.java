package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.home.HomeScreen;
import screens.login.LoginScreen;
import steps.base.BaseTest;
import org.testng.Assert;

public class LoginSteps extends BaseTest {
    LoginScreen loginScreen = new LoginScreen();
    HomeScreen homeScreen = new HomeScreen();
    String username;
    String userPassword;

    @Given("The user is on the Login screen")
    public void the_user_opens_the_application(){

    }

    @When("The user enter the valid email and password")
    public void the_user_enter_the_valid_email_and_password(){
        username =getRandomEmail();
        userPassword =getRandomNumber(6);

        loginScreen.enterEmail(username);
        loginScreen.enterPassword(userPassword);

        attachTextToReport("Username: "+ username
                + "\nPassword: " + userPassword,
                "User credentials");
    }

    @Then("The app might redirect to Home screen")
    public void the_app_might_redirect_to_home_screen(){
        Assert.assertTrue(homeScreen.isTitleDisplayed());
    }


    @When("The user enter the valid email and incomplete password")
    public void the_user_enter_the_valid_email_and_incomplete_password(){
        username =getRandomEmail();
        userPassword =getRandomNumber(4);

        loginScreen.enterEmail(username);
        loginScreen.typePassword(userPassword);

        attachTextToReport("Username: "+ username
                        + "\nPassword: " + userPassword,
                "User credentials");
    }

    @Then("The Login button might be disabled")
    public void the_login_button_might_be_disabled(){
        Assert.assertFalse(loginScreen.isLoginButtonEnabled(),"The Login button might be disabled on the Login screen");
    }

    @Then("The Home screen might display the username of the user")
    public void the_home_screen_might_display_the_username_of_the_user() {
        String usernameDisplayed = homeScreen.getUserNameLabel();
        attachTextToReport("Username: "+ usernameDisplayed,
                "Username displayed");
        Assert.assertTrue(usernameDisplayed.contains(username),"The Home screen does not display the correct user name");
    }
}
