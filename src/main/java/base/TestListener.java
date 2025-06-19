package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;
import utils.VideoRecorderUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        try {
            VideoRecorderUtil.startRecording(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseAnnotation) currentClass).driver;  // Get driver from BaseAnnotation
        ScreenshotUtil.captureScreenshot(driver, result.getName());
        try {
            VideoRecorderUtil.stopRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            VideoRecorderUtil.stopRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            VideoRecorderUtil.stopRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}

