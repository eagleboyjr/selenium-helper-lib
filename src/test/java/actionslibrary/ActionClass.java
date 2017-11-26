package actionslibrary;

import org.openqa.selenium.WebElement;

public abstract class ActionClass {

    WebElement element = null;

    abstract void select(WebElement element);

    abstract void deselect(WebElement element);

    abstract String getText(WebElement element);

    abstract void scrollPageToView(WebElement element);

    abstract void scrollPageTo(int i);

    abstract void scrollPageToCordinates(int i, int j);

}
