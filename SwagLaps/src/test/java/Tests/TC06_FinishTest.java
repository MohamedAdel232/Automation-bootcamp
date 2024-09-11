package Tests;

import Listeners.iInvokedMethodListener;
import Listeners.iTestResultListener;
import Pages.*;
import Utilities.LogsUtils;
import Utilities.Utility;
import com.github.javafaker.Faker;
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
public class TC06_FinishTest {

    private final String USERNAME = readDataFromJsonFile("validLogin", "username");
    private final String PASSWORD = readDataFromJsonFile("validLogin", "password");

    private final String firstName = readDataFromJsonFile("informations", "fName") + " " + Utility.getTimeStamp();
    private final String lastName = readDataFromJsonFile("informations", "lName") + " " + Utility.getTimeStamp();
    private final String postCode = new Faker().number().digits(5);

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
    public void finishOrderTC() {
        //TODO: Step one
        new P01_LoginPage(getDriver()).enterUserName(getDriver(), USERNAME)
                .enterPassword(getDriver(), PASSWORD)
                .clickLogin(getDriver());

        //TODO: Step two
        new P02_LandingPage(getDriver()).addRandomProducts(3, 6)
                .clickOnCartIcon();

        //TODO: Step three
        new P03_CartPage(getDriver()).clickOnCehckoutButton();

        //TODO: Step four
        new P04_CheckoutPage(getDriver()).fillInformation(firstName, lastName, postCode)
                .clickOnContinuewButton();
        LogsUtils.info(firstName + " " + lastName + " " + postCode);

        //TODO: Step five
        new P05_OverviewPage(getDriver()).clickOnFinishButton();

        Assert.assertTrue(new P06_FinishPage(getDriver()).checkThanksMessage());
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
