package Tests;

import Listeners.iInvokedMethodListener;
import Listeners.iTestResultListener;
import Pages.P01_LoginPage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.driverFactory.*;
import static Utilities.DataUtils.readDataFromJsonFile;
import static Utilities.DataUtils.readDataFromProperties;

@Listeners({iInvokedMethodListener.class, iTestResultListener.class})
public class TC01_LoginTest {

    private final String USERNAME = readDataFromJsonFile("validLogin", "username");
    private final String PASSWORD = readDataFromJsonFile("validLogin", "password");

    @BeforeMethod
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") :
                readDataFromProperties("environments", "Browser");
        LogsUtils.info(System.getProperty("browser"));
        setupDriver(browser);
        LogsUtils.info("Select a browser");
        getDriver().get(readDataFromProperties("environments", "BASE_URL"));
        LogsUtils.info("Open URL");
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void validLoginTC() throws IOException {
        new P01_LoginPage(getDriver()).enterUserName(getDriver(), USERNAME)
                .enterPassword(getDriver(), PASSWORD)
                .clickLogin(getDriver());

        Assert.assertTrue(new P01_LoginPage(getDriver()).assertValidLoginTC(getDriver(), readDataFromProperties("environments", "HOME_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}