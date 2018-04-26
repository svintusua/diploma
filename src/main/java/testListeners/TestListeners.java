package testListeners;

import org.testng.*;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static ui.utils.Screenshot.takeScreenshotFullPage;

public class TestListeners implements ITestListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            try {
                if (hasWebDriverStarted())
                    takeScreenshotFullPage("Скриншот послднего шага");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (hasWebDriverStarted()) {
                    getWebDriver().close();
                    getWebDriver().quit();
                }
            }
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
