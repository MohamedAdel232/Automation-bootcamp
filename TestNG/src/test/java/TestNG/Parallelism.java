package TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

//@Listeners(iInvokedMethod.class)
public class Parallelism
{
    // Create a web driver
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Create a soft assert object
    private static SoftAssert softAssert;

    @Parameters (value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser)
    {
        // Initialize test cases
        switch (browser)
        {
            case "edge": driverThreadLocal.set(new EdgeDriver());  break;
            default:  driverThreadLocal.set(new ChromeDriver()); break;
        }
        driverThreadLocal.get().get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driverThreadLocal.get().manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void logInValidTestCaseHardAssertion1(@Optional("admin") String username, @Optional("admin") String password)
    {
        // Get username, password, sign in button web elements
        By userNameLocator = By.id("inputUsername");
        By passwordLocator = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button
        driverThreadLocal.get().findElement(userNameLocator).sendKeys(username);
        driverThreadLocal.get().findElement(passwordLocator).sendKeys(password);
        driverThreadLocal.get().findElement(signInButton).click();

        // Evaluate that the log-in is done successfully
        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @Parameters({"username", "password"})
    @Test
    public void logInValidTestCaseHardAssertion2(@Optional("admin") String username, @Optional("admin") String password)
    {
        // Get username, password, sign in button web elements
        By userNameLocator = By.id("inputUsername");
        By passwordLocator = By.id("inputPassword");
        By signInButton = By.id("loginButton");

        // Input username, password and click on sign in button
        driverThreadLocal.get().findElement(userNameLocator).sendKeys(username);
        driverThreadLocal.get().findElement(passwordLocator).sendKeys(password);
        driverThreadLocal.get().findElement(signInButton).click();

        // Evaluate that the log-in is done successfully
        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        // Close the browser after executing test cases
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
