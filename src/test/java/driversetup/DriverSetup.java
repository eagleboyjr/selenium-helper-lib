package driversetup;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public interface DriverSetup {


    default WebDriver initializeLocalDriver(String browser){

        WebDriver driver = null;

        driver = getDriver(driver, browser);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        return driver;
    }

    default WebDriver getDriver(WebDriver driver, String browserName){

        String name = browserName.toLowerCase();

        switch(name){

            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "explorer":
                driver= new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }

        return driver;
    }

    default WebDriver initializeRemoteDriver(String browser, String nodeURL) throws MalformedURLException {

        WebDriver driver = null;
        driver = getRemoteDriver(driver, browser, nodeURL);
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        return driver;
    }

    default WebDriver getRemoteDriver(WebDriver driver, String browserName, String nodeURL) throws MalformedURLException {

        String name = browserName.toLowerCase();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch(name){

            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            case "explorer":
                capabilities = DesiredCapabilities.internetExplorer();
                break;
            case "edge":
                capabilities = DesiredCapabilities.edge();
                break;
            default:
                capabilities = DesiredCapabilities.firefox();
        }

        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);

        return driver;

    }

}
