package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static utils.UtilConstants.PROJECT_NAME;

public class Image {

    public void takeScreenshot(WebDriver driver, String path) throws IOException {
        String fileName = PROJECT_NAME + Randomize.randomNum() + ".png";
        String compPath = path + "/" + fileName;

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(compPath));
    }

    public void createImageFile(){

    }
}
