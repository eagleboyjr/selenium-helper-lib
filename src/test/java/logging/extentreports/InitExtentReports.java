package logging.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static logging.extentreports.Constants.DOC_TITLE;
import static logging.extentreports.Constants.OUTPUT_HTML;

public class InitExtentReports {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent ==null)
            createInstance(OUTPUT_HTML);

        return extent;
    }

    public static ExtentReports createInstance(String fileName){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle(DOC_TITLE);

        extent = new ExtentReports();
        extent.setSystemInfo("OS : ", System.getProperty("os.name"));
        extent.attachReporter(htmlReporter);
        return extent;
    }


}
