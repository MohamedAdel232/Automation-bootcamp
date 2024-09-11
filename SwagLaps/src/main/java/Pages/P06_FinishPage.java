package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_FinishPage {
    private final By thanksMessage = By.className("complete-header");
    private final WebDriver driver;

    public P06_FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkThanksMessage() {
        return driver.findElement(thanksMessage).isDisplayed();

    }
}
