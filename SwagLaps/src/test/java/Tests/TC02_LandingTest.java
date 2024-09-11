package Tests;

import Listeners.iInvokedMethodListener;
import Listeners.iTestResultListener;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static DriverFactory.driverFactory.*;
import static Utilities.DataUtils.readDataFromJsonFile;
import static Utilities.DataUtils.readDataFromProperties;
import static Utilities.Utility.restoreSession;

@Listeners({iInvokedMethodListener.class, iTestResultListener.class})
public class TC02_LandingTest {
    private final String USERNAME = readDataFromJsonFile("validLogin", "username");
    private final String PASSWORD = readDataFromJsonFile("validLogin", "password");
    private Set<Cookie> cookies;

    @BeforeClass
    public void login() throws IOException {
        setupDriver(readDataFromProperties("environments", "Browser"));
        LogsUtils.info("Select a browser");
        getDriver().get(readDataFromProperties("environments", "BASE_URL"));
        LogsUtils.info("Open URL");
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        new P01_LoginPage(getDriver()).enterUserName(getDriver(), USERNAME)
                .enterPassword(getDriver(), PASSWORD)
                .clickLogin(getDriver());

        cookies = Utility.getAllCookies(getDriver());
        quitDriver();
    }

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(readDataFromProperties("environments", "Browser"));
        LogsUtils.info("Select a browser");
        getDriver().get(readDataFromProperties("environments", "BASE_URL"));
        LogsUtils.info("Open URL");
        restoreSession(getDriver(), cookies);
        getDriver().get(readDataFromProperties("environments", "HOME_URL"));
        getDriver().navigate().refresh();
    }

    @Test
    public void checkingNumberOfSelectedProductsTC() {
        new P02_LandingPage(getDriver()).addAllProductToCart();
        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfSelectedProductsWithCart());
    }

    @Test
    public void addingRandomNumberOfProductsTC() {
        new P02_LandingPage(getDriver())
                .addRandomProducts(3, 6);

        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfSelectedProductsWithCart());
    }

    @Test
    public void clickOnCartIconTC() throws IOException {
        new P02_LandingPage(getDriver())
                .clickOnCartIcon();

        Assert.assertTrue(Utility.verifyURL(getDriver(), DataUtils.readDataFromProperties("environments", "CART_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }

    @AfterClass
    public void removeSession() {
        cookies.clear();
    }
}
