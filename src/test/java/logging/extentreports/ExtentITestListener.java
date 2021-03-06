package logging.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static logging.extentreports.Constants.DESC;
import static logging.extentreports.Constants.TITLE;

public class ExtentITestListener implements ITestListener {

    private static ExtentReports extent = ExtentUtils.getInstance();
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        ExtentTest child = parentTest.get().createNode(iTestResult.getMethod().getDescription());
        String[] categories = iTestResult.getMethod().getGroups();
        for(String category : categories){
            child.assignCategory(category);
        }
        test.set(child);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {

        test.get().pass(MarkupHelper.createLabel("Status: Passed", ExtentColor.GREEN));
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        test.get().fail(iTestResult.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        test.get().skip("Test Skipped");
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        ExtentTest parent = extent.createTest(TITLE, DESC);
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}
