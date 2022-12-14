package Utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    ExtentReports extent;
    public ExtentReports ReportGenerator()
    {
        String path=System.getProperty("user.dir")+"\\Reports\\Report.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Wisescore APK Automation");
        reporter.config().setDocumentTitle("Test Results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Manoj", "Tester");
        return extent;
    }
}

