package actionslibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface FormActions{

    WebElement element = null ;

    default void enterText(String s, WebElement element){
        element.clear();
        element.sendKeys(s);
    }

    default void uploadFile(String file, WebElement element){element.sendKeys(file); }

    default void selectDropDownByVal(String s, WebElement element){
        getDropdownObj(element).selectByValue(s);
    }

    default void selectDropDownByIndex(int i, WebElement element){
        getDropdownObj(element).selectByIndex(i);
    }

    default void selectDropDownByText(String s, WebElement element){
        getDropdownObj(element).selectByVisibleText(s);
    }

    default Select getDropdownObj(WebElement element){
        return new Select(element);
    }

}
