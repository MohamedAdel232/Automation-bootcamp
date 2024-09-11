import Pages.P01_LoginPage;
import Utilities.Utility;
import Utilities.dataUtilities;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest
{
    private WebDriver driver;

    String fakeUsername = new Faker().name().username();

    @BeforeMethod
    public void setupDriver() throws IOException
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dataUtilities.readDataFromProperties("environments", "LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void validLogin() throws IOException
    {
        /*loginPage = new Pages.P01_LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLigin(); */

        enterUserName();
        new P01_LoginPage(driver).enterPassword(dataUtilities.readDataFromJsonFile("validLoginData", "password"))
                                .clickLogin();

        Utility.takeScreenshoot(driver, "name");

        Assert.assertEquals(driver.getCurrentUrl(), dataUtilities.readDataFromProperties("environments", "HOME_URL"));
    }

    @Step("Step one")
    public void enterUserName() throws FileNotFoundException {
        new P01_LoginPage(driver).enterUsername(dataUtilities.readDataFromJsonFile("validLoginData", "username"));
    }


    @Test
    public void invalidLogin() throws IOException
    {
        /*loginPage = new Pages.P01_LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLigin(); */

        new P01_LoginPage(driver).enterUsername(fakeUsername)
                .enterPassword(dataUtilities.readDataFromJsonFile("validLoginData", "password"))
                .clickLogin();

        Assert.assertEquals(driver.getCurrentUrl(), dataUtilities.readDataFromProperties("environments", "HOME_URL"));
    }

    @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }
}
