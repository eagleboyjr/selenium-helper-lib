package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static utils.UtilConstants.PROJECT_NAME;

public class Image {

    public void takeScreenshot(WebDriver driver, String path) throws IOException {

        String fileName = PROJECT_NAME + Randomize.randomNum() + ".png";
        String fullPath =concatAndPathAndFile(fileName, path);
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(fullPath));
    }

    public void createImageFile(String path, int fileSize, String fileType ) throws IOException {

        String fileName = PROJECT_NAME +  Randomize.randomNum() + ".pgm";
        String completePath = concatAndPathAndFile(fileName, fileName);
        File file = new File(completePath);

        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write("P5\n".getBytes(StandardCharsets.UTF_8));
        out.write("255\n".getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < fileSize; i++) {
            out.write(0);
        }

        if(!fileType.equals("pgm")){ convertFile(completePath, fileType);}
    }

    private String concatAndPathAndFile(String file, String filePath){
         return filePath + "/" + file;
    }

    public void convertFile(String fullPath, String imageType){

    }
}
