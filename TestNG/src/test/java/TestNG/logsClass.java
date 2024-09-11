package TestNG;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class logsClass
{
    // Create a web driver
    private static WebDriver driver ;

    public static Logger LOGGER = LogManager.getLogger();

    // Create a soft assert object
    private static SoftAssert softAssert;

    @Parameters(value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser)
    {
        // Initialize test cases
        switch (browser)
        {
            case "edge": driver = new EdgeDriver(); break;
            default: driver = new ChromeDriver(); break;
        }
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void logInValidTestCaseHardAssertion(@Optional("admin") String username, @Optional("admin") String password)
    {
        LOGGER.info("Test case Started!");
        // Get username, password, sign in button web elements
        By userNameLocator = By.id("inputUsername");
        By passwordLocator = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button
        driver.findElement(userNameLocator).sendKeys(username);
        LOGGER.info("User name added");
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signInButton).click();

        LOGGER.warn("fault");

        // Evaluate that the log-in is done successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        // Close the browser after executing test cases
        driver.quit();
    }
}

