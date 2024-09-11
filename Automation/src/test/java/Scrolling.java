import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Scrolling
{
    // Create a driver
    public static WebDriver driver = new ChromeDriver();
    //public static WebDriver driver;

    public static void main(String[] args) throws IOException, AWTException, URISyntaxException {
        //editDriverOptions();
        openURL("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //uploadUsingRobot("F:\\SW Testing\\Java\\Java Workspace\\Automation\\src\\test\\java\\Action.java");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        checkBrokenUsingRestAssured(elements, "href");
    }

    // A function to open an url
    public static void openURL (String url)
    {
        driver.get(url);
        //driver.manage().window().maximize();
    }

    public static void checkBrokenUsingRestAssured(List<WebElement> elements, String type) throws IOException, URISyntaxException {
        URL url = null;

        String attribute;
        if (type.equals("photo"))
        {
            attribute = "src";
        }
        else
        {
            attribute = "href";
        }
        for (WebElement element: elements)
        {
            url = new URI(element.getAttribute(attribute)).toURL();
            Response response = RestAssured.given().get(url);
            System.out.println(response.getStatusLine());
        }
    }

    public static void checkBroken(List<WebElement> elements, String type) throws IOException, URISyntaxException {
        URL url = null;

        String attribute;
        if (type.equals("photo"))
        {
            attribute = "src";
        }
        else
        {
            attribute = "href";
        }
        for (WebElement element: elements)
        {
            url = new URI(element.getAttribute(attribute)).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseMessage() + " " + httpURLConnection.getResponseCode());
        }
    }

    // A function to edit driver options
    public static void editDriverOptions()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--guest");
        //option.addArguments("--headless");
        option.addArguments("--start-maximized");

        driver = new ChromeDriver(option);
    }


    // A function to upload file with robot
    public static void uploadUsingRobot(String path) throws AWTException {
        By locator = By.id("file-upload");
        driver.findElement(locator).click();

        StringSelection str = new StringSelection(path); // CTR C
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

        Robot robot = new Robot();

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    // A function to upload a file
    public static void uploadFile(String path)
    {
        By locator = By.id("file-upload");
        driver.findElement(locator).sendKeys(path);
    }

    // A function to take a screenshot
    public static void takingScreenShoot(String imgName) throws IOException {
        String path = "F:\\SW Testing\\Java\\Java Workspace\\Automation\\src\\test\\java\\";
        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File src = driver.findElement(By.className("heading")).getScreenshotAs(OutputType.FILE);
        File Target = new File(path+imgName+".png");
        FileUtils.copyFile(src, Target);
    }

    // A function to scroll using js
    public static void scrollUsingJS()
    {
        ((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoView();"
        ,driver.findElement(By.id("scroll_text")));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                .not(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.id("scroll_text")), "disabled")));

        driver.findElement(By.id("scroll_text")).sendKeys("Hello");
    }
}
