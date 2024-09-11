import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openURL("https://the-internet.herokuapp.com/hovers");
        hover();

    }

    // A function to open a url
    public static void openURL (String url)
    {
        driver.get(url);
    }

    // A function to double-click
    public static void doubleClick()
    {
        By locator = By.tagName("h3");
        new Actions(driver).doubleClick(driver.findElement(locator)).perform();
    }

    // A function to right-click
    public static void rightClick()
    {
        By locator = By.cssSelector("div[id='hot-spot']");
        new Actions(driver).contextClick(driver.findElement(locator)).perform();
    }

    // A function to drag and drop
    public static void dragAndDrop()
    {
        By locator_a = By.id("column-a");
        By locator_b = By.id("column-b");
        new Actions(driver).dragAndDrop(driver.findElement(locator_a), driver.findElement(locator_b)).perform();
    }

    // A function to click and hold
    public static void clickAndHold()
    {
        By locator_a = By.id("column-a");
        By locator_b = By.id("column-b");
        new Actions(driver).clickAndHold(driver.findElement(locator_a))
                            .moveToElement(driver.findElement(locator_b))
                            .release()
                            .build()
                            .perform();
    }

    // A function to click and hover
    public static void hover()
    {
        By locator = By.xpath("//div [@class='figure'][1]");
        new Actions(driver).moveToElement(driver.findElement(locator)).perform();
    }
}
