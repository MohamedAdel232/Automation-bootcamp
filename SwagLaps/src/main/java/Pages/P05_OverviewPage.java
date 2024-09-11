package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_OverviewPage {
    private final By subTotalLocator = By.className("summary_subtotal_label");
    private final By TaxLocator = By.className("summary_tax_label");
    private final By TotalLocator = By.className("summary_total_label");
    private final By finishButton = By.id("finish");
    private final WebDriver driver;

    public P05_OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public float getSubTotal() {
        return Float.parseFloat(Utility.getText(driver, subTotalLocator).replace("Item total: $", ""));
    }

    public float getTax() {
        return Float.parseFloat(Utility.getText(driver, TaxLocator).replace("Tax: $", ""));
    }

    public float getTotal() {
        LogsUtils.info("Actual Total Price: " + Utility.getText(driver, TotalLocator).replace("Total: $", ""));
        return Float.parseFloat(Utility.getText(driver, TotalLocator).replace("Total: $", ""));
    }

    public String calculateTotalPrice() {
        LogsUtils.info("Calculated Total Price: " + (getSubTotal() + getTax()));
        return String.valueOf(getSubTotal() + getTax());
    }

    public boolean comparePrice() {
        return calculateTotalPrice().equals(String.valueOf(getTotal()));
    }

    public P06_FinishPage clickOnFinishButton() {
        Utility.clickOnElement(driver, finishButton);
        return new P06_FinishPage(driver);
    }
}
