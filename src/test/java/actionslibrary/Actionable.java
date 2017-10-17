package actionslibrary;

import org.openqa.selenium.WebElement;

public interface Actionable{

    WebElement element = null;

    void click(WebElement element);

    void select(WebElement element);

    void deselect(WebElement element);

    String getText(WebElement element);

    void scrollPageToView(WebElement element);

    void scrollPageTo(int i);

    void scrollPageToCordinates(int i, int j);

}
