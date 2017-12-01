package actionslibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static actionslibrary.ActionsConsts.SCROLL_TO_COORDS;
import static actionslibrary.ActionsConsts.SCROLL_TO_VIEW;


public class Actions implements BaseActions {

    WebElement element = null;
    private WebDriver driver;

    @Override
    public void click(WebElement element){
        element.click();
    }

    public   String getText(WebElement element){
        return element.getText();
    }

    @Override
    public void scrollPageToView(WebElement element) {
        ((JavascriptExecutor)driver).executeScript( SCROLL_TO_VIEW, element);

    }

    @Override
    public void scrollPageTo(int i) {

    }

    @Override
    public void scrollPageToCordinates(int x, int y) {
        ((JavascriptExecutor)driver).executeScript(getCoordinates(x,y));

    }

    private String getCoordinates(int x, int y){
        return SCROLL_TO_COORDS + "(" + x +"," +y +");";
    }

    @Override
    public void select(WebElement element) {
        if (!element.isSelected())
            element.click();
    }

    @Override
    public void deselect(WebElement element){
        if (element.isSelected())
            element.click();
    }

}
