package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage
{
    private WebDriver driver;

    private final By userNameLocator = By.id("inputUsername");
    private final By passwordLocator = By.id("inputPassword");
    private final By loginButtonLocator = By.id("loginButton");

    public P01_LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername (String username)
    {
        //driver.findElement(userNameLocator).sendKeys(username);
        Utility.sendData(driver, userNameLocator, username);
        return this;
    }

    public P01_LoginPage enterPassword (String password)
    {
        //driver.findElement(passwordLocator).sendKeys(password);
        Utility.sendData(driver, passwordLocator, password);

        return this;
    }

    public P02_HomePage clickLogin ()
    {
        //driver.findElement(loginButtonLocator).click();
        Utility.clickOnElement(driver,loginButtonLocator);
        return new P02_HomePage(driver);
    }
}
