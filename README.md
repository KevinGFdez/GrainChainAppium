# Grain chain test appium

## Set up Properties and Runner

### Properties
Set node and appium path on the [src/test/java/config.properties](src/test/java/config.properties)

    nodePath: Node js absolut path.
    appiumPath: Appium absolut path.
    alwaysRecord: Flag to record all the time or only when the test case was fialed.

### Runner

Set device name, device udid on the [src/test/java/runners/AndroidRunner.java](src/test/java/runners/AndroidRunner.java)

    deviceName: Name of the device where the test case will be executed.
    deviceUdid: Udid of the device where the test case will be executed.
    appPath(Optional): If the Grain chain app is not installed on the device, 
                        set the absolut path where grain chain apk is located.

## Run test

Execute the [src/test/java/runners/AndroidRunner.java](src/test/java/runners/AndroidRunner.java)

## Html reports (Allure)

To view the html report we have to open a terminal and execute the command:
Allure serve "Absolute path of the HTML report"

Example:

```sh
Allure serve E:\Automation\Appium\GrainChainAppium\test-output
```
The html report must open in our default browse.


**Note:** We have to have Allure installed on our computer.