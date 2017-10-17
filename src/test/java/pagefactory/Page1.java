package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagefactory.pagefactorysupport.PageFactoryActions;

import java.util.List;

public class Page1 extends PageFactoryActions {

    private WebDriver driver;

    public Page1(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id="ctl00_ContentPlaceHolder1_PhotoAdminButton")
    static WebElement imageButton;

    @FindBy(id="ctl00_ContentPlaceHolder1_UploadControl")
    static WebElement chooseFile;

    @FindBy(id="ctl00_ContentPlaceHolder1_UploadButton")
    static WebElement uploadButton;

    public void click(){
        click(imageButton);
    }

    public void enterFile(String s){
        uploadFile(s,chooseFile);
        click(uploadButton);
    }
}
