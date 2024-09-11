import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main (String [] args)
    {
        openURL("https://the-internet.herokuapp.com/dropdown");
        dropDown();

    }

    // A function to go to open url
    public static void openURL (String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    // A function to handle drop down
    public static void dropDown()
    {
        By dropDownLocator = By.cssSelector("select#dropdown");
        //new Select(driver.findElement(dropDownLocator)).selectByIndex(1);
        //new Select(driver.findElement(dropDownLocator)).selectByValue("1");
        //new Select(driver.findElement(dropDownLocator)).selectByVisibleText("Option 1");
        /*String s = new Select(driver.findElement(dropDownLocator)).getFirstSelectedOption().getText();
        System.out.println(s);*/
        int size = new Select(driver.findElement(dropDownLocator)).getOptions().size();
        System.out.println(size);

    }
}
