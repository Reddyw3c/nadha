package Extent_Reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	ExtentTest test;
	String repName;
 public void onStart(ITestContext context) {
	 String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
	 repName ="Test-report-"+timeStamp+ ".html";
	 sparkReporter = new ExtentSparkReporter(".\\Reports\\"+repName);
	 sparkReporter.config().setDocumentTitle("Adactin Application Report");
	 sparkReporter.config().setReportName("Adactin Functional Testing");
	 sparkReporter.config().setTheme(Theme.STANDARD);
	 
	 extent = new ExtentReports();
	 extent.attachReporter(sparkReporter);
	 extent.setSystemInfo("Application", "Adactin");
	 extent.setSystemInfo("module", "Admin");
	 extent.setSystemInfo("Environment", "QA");
 }
 public void onTestSuccess(ITestResult result) {
	 test = extent.createTest(result.getName());
	 test.log(Status.PASS, "pass the results:"+result.getName());
 }
 public void onTestFailure(ITestResult result) {
	 test = extent.createTest(result.getName());
	 test.log(Status.FAIL, "fail the test:"+result.getName());
	 test.log(Status.FAIL, "fail the testcase:"+result.getThrowable());
 }
 public void onTestSkipped(ITestResult result) {
	 test = extent.createTest(result.getName());
	 test.log(Status.SKIP,"skip the testcase:"+result.getName());
	 test.log(Status.SKIP, "skip the testcase:"+result.getThrowable());
 }
 public void onTestFinish(ITestContext context) {
	 extent.flush();
 }
}
