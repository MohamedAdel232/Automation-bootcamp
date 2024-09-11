package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Dependencies
{
    // Create a web driver
    private static WebDriver driver ;

    @BeforeMethod
    public void setUp()
    {
        // Initialize test cases
        driver = new ChromeDriver();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().window().maximize();
    }

    @Test
    public void signUpTestCase()
    {
        //System.out.println("Sign up");
        Assert.fail();
    }

    @Test (dependsOnMethods = "signUpTestCase")
    public void logInTestCase1()
    {
        System.out.println("Log-in");
    }

    @Test (dependsOnMethods = "signUpTestCase", alwaysRun = true)
    public void logInTestCase2()
    {
        System.out.println("Log-in");
    }

    @AfterMethod
    public void quit()
    {
        // Close the browser after executing test cases
        driver.quit();
    }
}
