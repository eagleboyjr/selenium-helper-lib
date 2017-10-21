package logging.extentreports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.converters.ExtentHtmlLogConverter;

import static logging.extentreports.Constants.DOC_TITLE;

public class InitExtentReports {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent ==null)
            createInstance("log-output/extentReport.html");

        return extent;
    }

    public static ExtentReports createInstance(String fileName){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle(DOC_TITLE);

        extent = new ExtentReports();
        //extent.setSystemInfo(("OS : ", sysprop.get("os.name"));
        extent.attachReporter(htmlReporter);

        return extent;
    }

}
