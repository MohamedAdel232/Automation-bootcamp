package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class P02_LandingPage {
    private static List<WebElement> allProducts;
    private static List<WebElement> selecedProducts;
    private final WebDriver driver;
    private final By addToCartButtonForAllProducts = By.xpath("//button[@class]");
    private final By numberOfProductsOnCart = By.className("shopping_cart_badge");
    private final By numberOfSelectedProducts = By.xpath("//button[.='Remove']");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By selectedItemsPrice = By.xpath("//div //button[.='Remove'] //preceding-sibling::div [@class='inventory_item_price']");
    float totalPrice = 0;

    public P02_LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getNumberOfSelectedProductsOnCarts() {
        return numberOfProductsOnCart;
    }

    public P02_LandingPage addAllProductToCart() {
        allProducts = driver.findElements(addToCartButtonForAllProducts);
        LogsUtils.info("Number of all products " + allProducts.size());
        for (int index = 1; index <= allProducts.size(); index++) {
            By addToCartButtonForAllProducts = By.xpath("(//button[@class])[" + index + "]");
            Utility.clickOnElement(driver, addToCartButtonForAllProducts);
        }
        return this;
    }

    public String getNumberOfProductsOnCart() {
        try {
            LogsUtils.info("Number of products on cart " + Utility.getText(driver, numberOfProductsOnCart));
            return Utility.getText(driver, numberOfProductsOnCart);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }
    }

    public String getNumberOfSelectedProducts() {
        try {
            selecedProducts = driver.findElements(numberOfSelectedProducts);
            LogsUtils.info("Number of selected products " + selecedProducts.size());
            return String.valueOf(selecedProducts.size());
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }
    }

    public boolean comparingNumberOfSelectedProductsWithCart() {
        return getNumberOfProductsOnCart().equals(getNumberOfSelectedProducts());
    }

    public P02_LandingPage addRandomProducts(int numberOfProductsNeeded, int totalNumberOfProducts) {
        Set<Integer> randomNumbers = Utility.generateUniqueNumber(numberOfProductsNeeded, totalNumberOfProducts);
        for (int random : randomNumbers) {
            LogsUtils.info("Random number: " + random);
            By addToCartButtonForAllProducts = By.xpath("(//button[@class])[" + random + "]");
            Utility.clickOnElement(driver, addToCartButtonForAllProducts);
        }
        return this;
    }

    public P03_CartPage clickOnCartIcon() {
        Utility.clickOnElement(driver, cartIcon);
        return new P03_CartPage(driver);
    }


    public String getTotalPriceOfSelectedItems() {
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


}
