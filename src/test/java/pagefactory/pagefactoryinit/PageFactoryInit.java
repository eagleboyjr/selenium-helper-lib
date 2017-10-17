package pagefactory.pagefactoryinit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.Page1;

public class PageFactoryInit {

    WebDriver driver;

    public PageFactoryInit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, Page1.class);
    }
}
