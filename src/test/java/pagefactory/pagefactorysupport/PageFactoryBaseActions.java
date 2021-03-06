package pagefactory.pagefactorysupport;

import actionslibrary.BrowserActions;
import actionslibrary.PageBaseActions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static pagefactory.pagefactconsts.PageFactConsts.MAX;
import static pagefactory.pagefactconsts.PageFactConsts.MIN;

public class PageFactoryBaseActions extends PageBaseActions implements FormActions, BrowserActions {


    protected void populateAgeDropDowns(List<WebElement> elements){
        for(WebElement listedElement : elements){
            Integer age = randomAge();
            String ageSelect = age.toString();
           if(listedElement.isDisplayed())
               selectDropDownByText(ageSelect, listedElement);
        }
    }

    private Integer randomAge(){
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }

}
