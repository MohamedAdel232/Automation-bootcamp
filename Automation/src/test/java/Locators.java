import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class Locators
{
    // Create a driver to test with
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openBrowser("https://the-internet.herokuapp.com/tables");
        manageWindow();
        By userInput = By.xpath("//table[@id='table1'] /tbody /tr");

        /*String S = driver.findElement(userInput).getText();
        System.out.println(S);*/

        List<WebElement> elements = driver.findElements(userInput);
        for (WebElement i : elements)
        {
            System.out.println(i.getText());
        }
    }

    // A function that open an url in a browser
    public static void openBrowser(String url)
    {
        driver.get(url);
    }

    // A function to manage window configurations
    public static void manageWindow ()
    {
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //driver.manage().window().minimize();
        //Dimension d = new Dimension(430, 932);
        //driver.manage().window().setSize(new Dimension(430, 932));
        //driver.manage().window().setPosition(new Point(100, 200));
    }
}
