package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static utils.UtilConstants.PROJECT_NAME;

public class Image {

    String fileName = PROJECT_NAME +  Randomize.randomNum();

    public void takeScreenshot(WebDriver driver, String path) throws IOException {

        String fileName = PROJECT_NAME + Randomize.randomNum() + ".png";
        String fullPath =concatAndPathAndFile(fileName, path);
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(fullPath));
    }

    public void createImageFile(String path, int fileSize, String fileType ) throws IOException {

        String namedFile = fileName + ".pgm";
        String completePath = concatAndPathAndFile(namedFile, path);
        File file = new File(completePath);

        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write("P5\n".getBytes(StandardCharsets.UTF_8));
        out.write("255\n".getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < fileSize; i++) {
            out.write(0);
        }


        if(!fileType.toLowerCase().equals("pgm")){ convertFile(completePath, path, fileType);}
    }

    private String concatAndPathAndFile(String file, String filePath){
         return filePath + "/" + file;
    }


    public void convertFile(String fullPath, String path, String imageType) throws IOException {

        String newFile = fileName + imageType;
        String filePath = concatAndPathAndFile(newFile, path);

        BufferedImage OriginalImage = ImageIO.read(new File(fullPath));

        BufferedImage newBufferedImage = new BufferedImage(OriginalImage.getWidth(),
                OriginalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        ImageIO.write(newBufferedImage, imageType, new File(filePath));

    }
}
