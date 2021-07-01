package Base;

import Logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ToolsManager extends BaseClass{

    public static void clickOnElement(By by){
        waitForElementIsPresent(by).click();
    }

    public static void sendKeys(By by, String value){
        waitForElementIsPresent(by).sendKeys(value);
    }

    //Clicking on "X" (close) button at the "Add to Cart" popup
    public  static void clickOnElementJSExecutor(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = waitForElementIsPresent(by);
        js.executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForElementIsPresent(By by) {
        Log.debug("waiting for element" + by);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 15)
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Boolean waitForValueToChange(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return !wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element,"0:00")));
    }
}
