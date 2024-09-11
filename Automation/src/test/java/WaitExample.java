import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitExample
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main (String [] args)
    {
        // implicitlyWait will work with /2 page but not /1
        // because /2 element does not appear in DOM until loading
        // but in /1 element is on DOM from the first but not visible
        //openURL("https://the-internet.herokuapp.com/dynamic_loading/1");

        openURL("https://the-internet.herokuapp.com/dynamic_loading/1");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        printHelloWorld();
    }

    // A function to go to open url
    public static void openURL (String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    // A function to get hello world
    public static void printHelloWorld()
    {
        By elementLocator1 = By.tagName("button");
        By elementLocator2 = By.xpath("//div[@id='finish'] //h4");

        driver.findElement(elementLocator1).click();
        //explicitWait(elementLocator2);
        fluentWait(elementLocator2);
        String s = driver.findElement(elementLocator2).getText();
        System.out.println(s);
    }

    public static void explicitWait (By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public static void fluentWait (By locator)
    {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .withMessage("Error!!")
                .pollingEvery(Duration.ofMillis(2L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
