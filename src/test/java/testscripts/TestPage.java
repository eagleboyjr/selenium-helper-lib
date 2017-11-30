package testscripts;

import com.sun.org.glassfish.gmbal.Description;
import driversetup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.Page1;
import pagefactory.pagefactoryinit.PageFactoryInit;
import static testscripts.testscriptsconsts.TestScriptConsts.BASE_URL;


public class TestPage implements DriverSetup{

    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) {
//        driver = initializeLocalDriver(browser);
//        PageFactoryInit driverInit = new PageFactoryInit(driver);
//        driver.get(BASE_URL);
    }

    @Test(description = "Testing first Assert", groups = {"regression"})
    public void test(){
        Assert.assertTrue(true);
    }

    @Test(description = "Testing second Assert", groups = {"regression"})
    public void test1(){
        Assert.assertTrue(true);
    }

    @Test(description = "Testing third Assert", groups = {"smoke"})
    public void test2(){
        Assert.assertTrue(false);
    }

    @Test(description = "Testing fourth Assert", groups = {"smoke","regression"})
    public void test3(){
        Assert.assertTrue(true);
    }

    @Test(description = "Testing fifth Assert", groups = {"sanity"})
    public void test4(){
        Assert.assertTrue(false);
    }



    @AfterClass
    public void tearDown(){

    }
}
