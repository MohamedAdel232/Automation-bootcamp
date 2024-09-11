import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Alerts
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openURL("https://the-internet.herokuapp.com/javascript_alerts");
        getTextAlert();
    }

    // A function to open an url
    public static void openURL (String url)
    {
        driver.get(url);
    }

    // A function to accept an alert
    public static void acceptAlert()
    {
        By buttonLocator = By.cssSelector("[onclick='jsAlert()']");
        driver.findElement(buttonLocator).click();
        driver.switchTo().alert().accept();
    }

    // A function to dismiss an alert
    public static void dismissAlert()
    {
        By buttonLocator = By.cssSelector("[onclick='jsConfirm()']");
        driver.findElement(buttonLocator).click();
        driver.switchTo().alert().dismiss();
    }

    // A function to enter a text in an alert
    public static void enterTextAlert()
    {
        By buttonLocator = By.cssSelector("[onclick='jsPrompt()']");
        driver.findElement(buttonLocator).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Mohamed");
        alert.accept();
    }

    // A function to get a text in an alert
    public static void getTextAlert()
    {
        By buttonLocator = By.cssSelector("[onclick='jsAlert()']");
        driver.findElement(buttonLocator).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}
