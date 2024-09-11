package Tests;

import Listeners.iInvokedMethodListener;
import Listeners.iTestResultListener;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Pages.P03_CartPage;
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
public class TC03_CartTest {

    private final String USERNAME = readDataFromJsonFile("validLogin", "username");
    private final String PASSWORD = readDataFromJsonFile("validLogin", "password");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readDataFromProperties("environments", "Browser"));
        LogsUtils.info("Select a browser");
        getDriver().get(readDataFromProperties("environments", "BASE_URL"));
        LogsUtils.info("Open URL");
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void comparePriceTC() {
        String price = new P01_LoginPage(getDriver()).enterUserName(getDriver(), USERNAME)
                .enterPassword(getDriver(), PASSWORD)
                .clickLogin(getDriver())
                .addRandomProducts(3, 6)
                .getTotalPriceOfSelectedItems();

        new P02_LandingPage(getDriver()).clickOnCartIcon();

        Assert.assertTrue(new P03_CartPage(getDriver()).compareTotalPriceOfSelectedItemsWithTotalPrice(price));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
