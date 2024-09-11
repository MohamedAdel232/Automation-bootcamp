import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openURL("https://the-internet.herokuapp.com/nested_frames");
        nestedFrames();

    }

    // A function to go to an url
    public static void openURL(String url)
    {
        driver.get(url);
    }

    // A function to go to frame
    public static void goToFrame()
    {
        By frameLocator = By.id("mce_0_ifr");
        By textBoxLocator = By.cssSelector("#tinymce p");
        driver.switchTo().frame(driver.findElement(frameLocator));
        driver.findElements(textBoxLocator).clear();
        driver.findElement(textBoxLocator).sendKeys("Mohamed");
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
    }

    // A function to handle nested frames
    public static void nestedFrames ()
    {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
