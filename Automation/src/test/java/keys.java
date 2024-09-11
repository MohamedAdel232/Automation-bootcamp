import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keys
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openURL("https://the-internet.herokuapp.com/key_presses");
        pressKey2();
    }

    // A function to open an url
    public static void openURL (String url)
    {
        driver.get(url);
    }

    // A function to press a key
    public static void pressKey1()
    {
        By locator = By.xpath("//*[@id=\"target\"]");
        driver.findElement(locator).sendKeys(Keys.CONTROL);
    }

    // A function to press a key
    public static void pressKey2()
    {
        // new Actions(driver).keyDown(Keys.ARROW_DOWN).perform();
         new Actions(driver).keyDown(driver.findElement(By.xpath("//*[@id=\"target\"]")),Keys.SHIFT)
                 .sendKeys("mohamed")
                 .keyUp(Keys.SHIFT)
                 .build()
                 .perform();
    }
}
