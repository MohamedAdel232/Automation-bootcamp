import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Windows
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static String firstTap;
    public static String secondTap;

    public static void main (String [] args)
    {
        openURL("https://the-internet.herokuapp.com/windows");

        Set<String> handles = openNewTap();
        for (String h : handles)
        {
            if (!h.equals(firstTap))
            {
                secondTap = h;
            }
        }
        System.out.println(driver.getCurrentUrl());
        switchTap(secondTap);
        System.out.println(driver.getCurrentUrl());

    }

    // A function to open an url
    public static void openURL(String url)
    {
        driver.get(url);
    }

    // A function to open new tap
    public static Set<String> openNewTap()
    {
        By locator = By.xpath("//div[@class='example'] //a [@target='_blank']");
        driver.findElement(locator).click();
        firstTap = driver.getWindowHandle();
        return driver.getWindowHandles();
    }

    // A function to switch to new tap
    public static void switchTap(String tapHandle)
    {
        driver.switchTo().window(tapHandle);
    }
}
