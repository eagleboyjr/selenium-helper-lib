package testscripts;

import driversetup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pagefactory.Page1;
import pagefactory.pagefactoryinit.PageFactoryInit;
import static testscripts.testscriptsconsts.TestScriptConsts.BASE_URL;


public class TestPage implements DriverSetup{

    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) {
        driver = initializeLocalDriver(browser);
        PageFactoryInit driverInit = new PageFactoryInit(driver);
        driver.get(BASE_URL);
    }

    @Test
    public void test(){
        Page1 pg1 = new Page1(driver);
        pg1.click();
        pg1.enterFile("C:\\Users\\Todd\\Pictures\\ISu0sesfwf419v0000000000.jpg");
    }

    @AfterClass
    public void tearDown(){

    }
}
