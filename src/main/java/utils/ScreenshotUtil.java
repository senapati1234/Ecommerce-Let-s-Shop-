package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // ✅ Store in project root under logs/screenshots
            String baseDir = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "screenshots";
            File screenshotFolder = new File(baseDir);

            // ✅ Create folder if it doesn't exist
            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs();  // <-- This line is very important
            }

            File destFile = new File(screenshotFolder, screenshotName + ".png");

            FileUtils.copyFile(srcFile, destFile);
            System.out.println("✅ Screenshot saved to: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
