package Listeners;

import Utilities.LogsUtils;
import Utilities.Utility;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static DriverFactory.driverFactory.getDriver;

public class iInvokedMethodListener implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        //Utility.takeFullScreenshoot(getDriver(), new P02_LandingPage(getDriver()).getNumberOfSelectedProductsOnCarts());
        File logFile = Utility.getLatestFile(LogsUtils.LOGS_PATH);
        try {
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("Test case: " + testResult.getName() + " failed");
            Utility.takeScreenshoot(getDriver(), testResult.getName());
        }
    }
}
