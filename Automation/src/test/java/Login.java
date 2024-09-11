import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Login
{
    // Create a driver to test with
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openBrowser("https://the-internet.herokuapp.com/login");
        manageWindow();
        sendData("tomsmith", "SuperSecretPassword!");
        clearText();
        clicking();
        getMessage();

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

    // A function that send data
    public static void sendData(String userName, String userPassword)
    {
        By userNameLocator = By.id("username");
        By userPasswordLocator = By.id("password");

        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(userPasswordLocator).sendKeys(userPassword);
    }

    // A function to click on elements
    public static void clicking ()
    {
        By ButtonLocator = By.className("radius");
        driver.findElement(ButtonLocator).click();
    }

    // A function to get text
    public static String getMessage ()
    {
        By msgLocator = By.cssSelector("div#flash");
        return driver.findElement(msgLocator).getText();
    }

    // A function to clear text
    public static void clearText()
    {
        By msgLocator = By.id("username");
        driver.findElement(msgLocator).clear();
    }
}
