package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import steps.base.BaseTest;

import java.io.File;
import java.net.URL;

public class AppiumServerManager {
    static String nodePath = BaseTest.getNodePath();
    static String appiumPath= BaseTest.getAppiumPath();
    private static final ThreadLocal<URL> serverUrl = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public static void setServerUrl(){
        serverUrl.set(getServer().getUrl());
    }
    public static URL getServerUrl(){
        return serverUrl.get();
    }

    public static void startServer(){
        setUpLocalServer();
        setServerUrl();
    }
    public static AppiumDriverLocalService getServer(){
        return server.get();
    }

    public static void setUpLocalServer(){
        try {
            AppiumDriverLocalService appiumServer;

            appiumServer = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File(nodePath)).withAppiumJS(new File(appiumPath))
                    .usingAnyFreePort()
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE));

            appiumServer.start();
            appiumServer.clearOutPutStreams();
            server.set(appiumServer);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void stopServer(){
        if (getServer().isRunning()){
            getServer().stop();
        }
    }
    
}
