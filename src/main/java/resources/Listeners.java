package resources;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class Listeners extends BaseClass implements ITestListener {

	private ExtentReports extent=new ExtentReports();
	private ExtentSparkReporter reporter=new ExtentSparkReporter("./reports/extent.html");
	private ExtentTest logger;
	public void onTestFailure(ITestResult result) {
	reporter.config().setTheme(Theme.DARK);
    //    reporter.config().setDocumentTitle("Test");
    //    reporter.config().setEncoding("utf-8");
  //      reporter.config().setReportName("Sital");
        
		try {
			String paa=takeScreenShot(driver);
	        extent.attachReporter(reporter);
	        logger=extent.createTest(result.getName());
			logger.fail(result.getThrowable(),  MediaEntityBuilder.createScreenCaptureFromPath(paa).build());
			logger.addScreenCaptureFromPath(paa);
	//		extent.setSystemInfo("Automation Tester", "Sital prasad");
			
			extent.flush();
		} catch (Exception e) {
	e.printStackTrace();
		}
	}}


