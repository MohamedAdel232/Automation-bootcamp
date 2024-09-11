import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main (String [] args)
    {
        openURL("https://the-internet.herokuapp.com/dynamic_loading/1");
        manageWindow();
        //implicitWait();
        helloWorld();
    }

    // A function for fluent wait
    public static void fluentWait(By locator)
    {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .withMessage("Error")
                .pollingEvery(Duration.ofMillis(2L))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    // A function for explicit wait
    public static void explicitWait(By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // A function to print hello world
    public static void helloWorld()
    {
        By button = By.xpath("//button");
        By text = By.xpath("//div[@id='finish'] //h4");

        driver.findElement(button).click();
        //explicitWait(text);
        fluentWait(text);

        System.out.println(driver.findElement(text).getText());
    }

    // A function for implicit wait
    public static void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // A function to get a text from a text box
    public static String getText()
    {
        By userNameLocator = By.tagName("h4");
        return driver.findElement(userNameLocator).getText();
    }

    // A function to clear a text from a text box
    public static void clearText()
    {
        By userNameLocator = By.cssSelector("[type='text']");
        driver.findElement(userNameLocator).clear();
    }

    // A function to click on a web element
    public static void click()
    {
        By buttonLocator = By.tagName("button");
        driver.findElement(buttonLocator).click();
    }

    // A function to send data to a text box
    public static void sendString(String userName, String userPassword)
    {
        By userNameLocator = By.cssSelector("[type='text']");
        By userPasswordLocator = By.cssSelector("[type='password']");

        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(userPasswordLocator).sendKeys(userPassword);
    }

    // A function to close current tap
    public static void closeAllTap()
    {
        driver.quit();
    }

    // A function to close current tap
    public static void closeTap()
    {
       driver.close();
    }

    // A function to get the window (tap) handle
    public static String getWindowHandle()
    {
        return driver.getWindowHandle();
    }

    // A function to get the source code of a web page
    public static String getSourceCode ()
    {
        return driver.getPageSource();
    }

    // A function to get the title of the web page
    public static String getPageTitle()
    {
        return driver.getTitle();
    }

    // A function to get the current url
    public static String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    // A function to manage window
    public static void manageWindow()
    {
        driver.manage().window().maximize();
    }

    // A function to navigate to another url
    public static void navigate()
    {
        driver.navigate().to("https://the-internet.herokuapp.com/abtest");
        driver.navigate().back();
        driver.navigate().forward();
    }

    // A function to open an url
    public static void openURL(String url)
    {
        driver.get(url);
    }
}
