package actionslibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageActions extends Actions{

    private WebDriver driver;

    public String getUserAgent(WebDriver driver){
        return (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
    }

}
