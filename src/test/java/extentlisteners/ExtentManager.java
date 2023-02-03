package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance(String filename) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filename);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(filename);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(filename);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Mosuwe Mosibi");
        extent.setSystemInfo("Organization", "Digilink");
        extent.setSystemInfo("Build", "Assessment 2");

        return extent;
    }
}
