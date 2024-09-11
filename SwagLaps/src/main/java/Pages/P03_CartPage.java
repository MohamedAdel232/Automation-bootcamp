package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_CartPage {
    private final WebDriver driver;

    private final By selectedItemsPrice = By.xpath("//div //button[.='Remove'] //preceding-sibling::div [@class='inventory_item_price']");
    private final By checkoutButton = By.id("checkout");
    float totalPrice = 0;

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalPrice() {
        try {
            List<WebElement> priceOfSelectedProducts = driver.findElements(selectedItemsPrice);
            for (int index = 1; index <= priceOfSelectedProducts.size(); index++) {
                By element = By.xpath("(//div //button[.='Remove'] //preceding-sibling::div [@class='inventory_item_price'])[" + index + "]");
                String fullText = Utility.getText(driver, element);
                totalPrice += Float.parseFloat(fullText.replace("$", ""));
            }
            LogsUtils.info("Total price: " + totalPrice);
            return String.valueOf(totalPrice);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }
    }

    public boolean compareTotalPriceOfSelectedItemsWithTotalPrice(String price) {
        return getTotalPrice().equals(price);
    }

    public P04_CheckoutPage clickOnCehckoutButton() {
        Utility.clickOnElement(driver, checkoutButton);
        return new P04_CheckoutPage(driver);
    }


}
