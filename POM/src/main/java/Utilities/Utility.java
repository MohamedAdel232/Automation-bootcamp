package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utility
{
    public static String SCREENSHOOT_PATH = "test-Outputs/Screenshoots/";

    public static void clickOnElement(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();
    }

    public static void sendData (WebDriver driver, By locator, String data)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.findElement(locator).sendKeys(data);
    }

    public static void takeScreenshoot (WebDriver driver, String screenshootName) throws IOException {
        File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenDes = new File(SCREENSHOOT_PATH + screenshootName + ".png");

        FileUtils.copyFile(screenSrc, screenDes);

        Allure.addAttachment(screenshootName, Files.newInputStream(Path.of(screenDes.getPath())));
    }
}
