package utils.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;


public class MediaManager {
    public static void startRecording(){
        AndroidStartScreenRecordingOptions androidRecordingOptions = new AndroidStartScreenRecordingOptions().withTimeLimit(Duration.ofMinutes(10));
        ((CanRecordScreen) AppiumDriverManager.getDriver()).startRecordingScreen(androidRecordingOptions);
    }

    public static void stopRecording(AppiumDriver driver, String scenarioName,String scenarioStatus, String deviceName) throws IOException {
        String media = ((CanRecordScreen) driver).stopRecordingScreen();

        String dirPath = "test-output/" + deviceName + "/videos";

        File videoDir = new File(dirPath);

        synchronized (videoDir) {
            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            stream = new FileOutputStream(videoDir + File.separator + scenarioStatus + "-" + scenarioName +".mp4");
            stream.write(Base64.getDecoder().decode(media));
            stream.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static byte[] takeScreenshot(AppiumDriver driver){
        return driver.getScreenshotAs(OutputType.BYTES);
    }

}
