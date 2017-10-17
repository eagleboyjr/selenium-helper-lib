package actionslibrary;

import org.openqa.selenium.WebDriver;
import java.util.Set;

import java.util.Set;

public interface BrowserActions {
    WebDriver driver = null;

    default void closeChildBrowsers(WebDriver driver){

        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles){
            if(!handle.equals(parentHandle)) {
                System.out.println(handle);
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
    }
}
