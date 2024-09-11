package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage {
    private final WebDriver driver;

    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckoutPage fillInformation(String firstName, String lastName, String postalCode) {
        Utility.sendData(driver, firstNameLocator, firstName);
        Utility.sendData(driver, lastNameLocator, lastName);
        Utility.sendData(driver, postalCodeLocator, postalCode);
        return this;
    }

    public P05_OverviewPage clickOnContinuewButton() {
        Utility.clickOnElement(driver, continueButton);
        return new P05_OverviewPage(driver);
    }
}

