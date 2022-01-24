@Login
Feature: Login
  @LoginSuccesful
  Scenario: TCLOGIN001 Login sucessfully
    Given The user is on the Login screen
    When The user enter the valid email and password
    Then The app might redirect to Home screen

  @ValidateLoginButton
  Scenario: TCLOGIN002 Validate login button disabled
    Given The user is on the Login screen
    When The user enter the valid email and incomplete password
    Then The Login button might be disabled

  @ValidateUserName
  Scenario: TCLOGIN003 Validate user name on the Home screen
    Given The user is on the Login screen
    When The user enter the valid email and password
    Then The Home screen might display the username of the user
