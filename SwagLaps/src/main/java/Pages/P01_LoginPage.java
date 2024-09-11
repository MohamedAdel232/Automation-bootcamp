package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final WebDriver driver;

    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUserName(WebDriver driver, String usernameText) {
        Utility.sendData(driver, usernameLocator, usernameText);
        return this;
    }

    public P01_LoginPage enterPassword(WebDriver driver, String passwordText) {
        Utility.sendData(driver, passwordLocator, passwordText);
        return this;
    }

    public P02_LandingPage clickLogin(WebDriver driver) {
        Utility.clickOnElement(driver, loginButtonLocator);
        return new P02_LandingPage(driver);
    }

    public boolean assertValidLoginTC(WebDriver driver, String expected) {
        return driver.getCurrentUrl().equals(expected);
    }
}
