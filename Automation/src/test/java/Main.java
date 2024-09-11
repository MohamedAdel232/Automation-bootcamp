import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{
    // Create driver
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        openBrowser("https://www.google.com/");

        /*navigateTo("https://www.facebook.com/");
        refreshPage();
        backPage();
        forwardPage();*/

        manageWindow();

        //getCurrentURL();

        //getTitle ();

        //getSourceCode();

        //getWindowHandle();

        //closeTabs();

        //quitTab();

    }

    // A function that open an url in a browser
    public static void openBrowser(String url)
    {
        driver.get(url);
    }

    // A function that navigate to an url in a browser
    public static void navigateTo(String url)
    {
        driver.navigate().to(url);
    }

    // A function that refresh a webpage
    public static void refreshPage ()
    {
        driver.navigate().refresh();
    }

    // A function that go back to a webpage
    public static void backPage ()
    {
        driver.navigate().back();
    }

    // A function that go forward to a webpage
    public static void forwardPage ()
    {
        driver.navigate().forward();
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

    // A function to get the current url
    public static void getCurrentURL ()
    {
        String url ;
        url = driver.getCurrentUrl();
        System.out.println(url);
    }

    // A function to get the title of the page
    public static void getTitle ()
    {
        String title ;
        title = driver.getTitle();
        System.out.println(title);
    }

    // A function to get the source code of the page
    public static void getSourceCode ()
    {
        String sourceCode ;
        sourceCode = driver.getPageSource();
        System.out.println(sourceCode);
    }

    // A function to get the handle ID of the page
    public static void getWindowHandle ()
    {
        String windowHandle ;
        windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
    }

    // A function to close current tab
    public static void closeTab ()
    {
        driver.close();
    }

    // A function to close all tabs
    public static void quitTabs ()
    {
        driver.quit();
    }
}
