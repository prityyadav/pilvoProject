package pilvo.common.utils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        File reportDir = new File(Constants.REPORTS_PATH);
        if (!reportDir.exists()) {
            reportDir.mkdir();
        }

        if (extent == null) {
            Date d = new Date();
            String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            String reportPath = Constants.REPORTS_PATH + fileName;

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.setAnalysisStrategy(AnalysisStrategy.CLASS);

            htmlReporter.config().setReportName(Constants.REPORTS_NAME);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle(Constants.DOCUMENT_TITLE);
            htmlReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }


}
