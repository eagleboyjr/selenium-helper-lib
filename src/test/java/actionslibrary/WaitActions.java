package actionslibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WaitActions {
    WebDriver driver = null;

    default void clickWhenVisible(WebDriver driver, WebElement element, long timeout){
        setWaitTime(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    default WebElement waitForElement(WebDriver driver, WebElement element, long timeout){

        return setWaitTime(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated((By)element));
    }

    default WebDriverWait setWaitTime(WebDriver driver, long timeOut){
       return new WebDriverWait(driver, timeOut);
    }
}
