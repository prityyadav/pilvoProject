package pilvo.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jayway.restassured.response.Response;

import pilvo.common.utils.ExtentManager;

public class BaseSetup {

	public Logger log;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest testReport;
	public ExtentTest testSteps;

	public Response response = null;

	public long getResponseTime() {
		long responseTime = response.time();
		return responseTime;
	}

	public void writeTestReportStatus(ITestResult result) {
		if (result.isSuccess()) {
			testSteps.log(Status.PASS, "Test Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testSteps.log(Status.FAIL, "Test Failed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			testSteps.log(Status.SKIP, "Test Skipped");
		}
		if (extent != null) {
			extent.flush();
		}
	}

//	@BeforeClass
//	public static void startTest() {
//		report = new ExtentReports(System.getProperty("user.dir") + "ExtentReportResults.html");
//		test = report.startTest("ExtentDemo");
//	}
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		testReport = extent.createTest(this.getClass().getSimpleName());
		log = LogManager.getLogger(this.getClass());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		testSteps = testReport.createNode(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		writeTestReportStatus(result);
	}

}
