import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBox
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main (String [] args)
    {
        openURL("https://the-internet.herokuapp.com/checkboxes");
        checkBox();

    }

    // A function to go to open url
    public static void openURL (String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    // A function to handle check box
    public static void checkBox()
    {
        By CheckBoxLocator1 = By.cssSelector("[type='checkbox']:nth-of-type(1)");
        By CheckBoxLocator2 = By.cssSelector("[type='checkbox']:nth-of-type(2)");

        driver.findElement(CheckBoxLocator1).click();
        driver.findElement(CheckBoxLocator2).click();

        System.out.println(driver.findElement(CheckBoxLocator1).isSelected());
        System.out.println(driver.findElement(CheckBoxLocator1).isDisplayed());
        System.out.println(driver.findElement(CheckBoxLocator1).isEnabled());

    }
}
