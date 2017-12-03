package actionslibrary;

import org.openqa.selenium.WebElement;

public abstract class SuperActions {

    WebElement element = null;

    abstract void click(WebElement element);

    abstract void select(WebElement element);

    abstract void deselect(WebElement element);

    abstract String getText(WebElement element);

    abstract void scrollPageToView(WebElement element);

    abstract void mouseOver(WebElement element, ActionType actionsType);

    abstract void scrollPageTo(int i);

    abstract void scrollPageToCordinates(int i, int j);



}
