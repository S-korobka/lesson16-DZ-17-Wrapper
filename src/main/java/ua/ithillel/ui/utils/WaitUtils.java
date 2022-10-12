package ua.ithillel.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class WaitUtils {
    public static void  waitUtilElementIsVisible(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(TimeoutException.class);
        wait.withMessage("Element is not visible");
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void  waitUtilElementIsVisible(WebDriver driver,By by){
     waitUtilElementIsVisible(driver,driver.findElement(by));
    }
    public static void  waitUtilElementIsDisappear(WebDriver driver,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.ignoring(TimeoutException.class);
        wait.withMessage("Element is not visible");
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
    }
}
