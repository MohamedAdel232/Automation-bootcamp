package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Grouping
{
    // Create a web driver
    private static WebDriver driver ;

    // Create a soft assert object
    private static SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        // Initialize test cases
        driver = new ChromeDriver();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"Regression"})
    public void logInValidTestCaseHardAssertion()
    {
        // Get username, password, sign in button web elements
        By userName = By.id("inputUsername");
        By password = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(password).sendKeys("admin");
        driver.findElement(signInButton).click();

        // Evaluate that the log-in is done successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @Test(priority = 2, groups = {"Regression", "Broken"})
    public void logInInValidTestCaseHardAssertion()
    {
        // Get username, password, sign in button web elements
        By userName = By.id("inputUsername");
        By password = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button and then accept the alert
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(password).sendKeys("admn");
        driver.findElement(signInButton).click();
        driver.switchTo().alert().accept();

        // Evaluate that the log-in is failed successfully
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @Test(priority = 3, groups = {"Smoke", "Broken"})
    public void logInInValidTestCaseSoftAssertion()
    {
        // Create new soft assert object
        softAssert = new SoftAssert();

        // Get username, password, sign in button web elements
        By userName = By.id("inputUsername");
        By password = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button and then accept the alert
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(password).sendKeys("admn");
        driver.findElement(signInButton).click();
        driver.switchTo().alert().accept();

        // Make two failed assertion to make sure that the soft assertion wait until the end to give exceptions
        boolean expected = driver.getCurrentUrl().equals("google.com");
        softAssert.assertTrue(expected);

        softAssert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        // Close the browser after executing test cases
        driver.quit();
    }
}
