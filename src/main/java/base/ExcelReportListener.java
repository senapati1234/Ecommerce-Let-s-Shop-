package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReportListener implements ITestListener {

    private List<String[]> testResults = new ArrayList<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Add header only once
        if (testResults.isEmpty()) {
            testResults.add(new String[]{"Test Case Name", "Status", "Error Logs"});
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testResults.add(new String[]{
                getTestDescription(result),
                "PASS",
                ""
        });
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testResults.add(new String[]{
                getTestDescription(result),
                "FAIL",
                result.getThrowable() != null ? result.getThrowable().getMessage() : ""
        });
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testResults.add(new String[]{
                getTestDescription(result),
                "SKIPPED",
                result.getThrowable() != null ? result.getThrowable().getMessage() : ""
        });
    }

    @Override
    public void onFinish(ITestContext context) {
        writeCSVReport();
    }

    private String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null && !result.getMethod().getDescription().isEmpty()
                ? result.getMethod().getDescription()
                : result.getMethod().getMethodName();
    }

    private void writeCSVReport() {
        try (FileWriter writer = new FileWriter("TestNG_Results.csv")) {
            for (String[] row : testResults) {
                writer.append(String.join(",", row)).append("\n");
            }
            System.out.println("CSV report generated: TestNG_Results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
