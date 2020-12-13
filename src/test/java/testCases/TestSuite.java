package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestSuite {

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setReport() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/report/extent.html");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Ananya Software Technologies | Report");
		htmlreporter.config().setReportName("Automation Test Results");
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Automation Tester", "XYZ");
		extent.setSystemInfo("Organization", "Ananya Software Technologies");
		extent.setSystemInfo("Build No", "W2-ABC");
	}

	@AfterTest
	public void endReport() {
		extent.flush();

	}

	@Test
	public void doLogin() {
		test = extent.createTest("Login Test");
		System.out.println("Executing Login Test");

	}

	@Test
	public void doUserReg() {
		test = extent.createTest("User Reg Test");
		System.out.println("User Reg Test");
		Assert.fail("User Reg Test Failed");

	}

	@Test
	public void doCustomerReg() {
		test = extent.createTest("Customer Reg Test");
		System.out.println("User Reg Test");
		Assert.fail("Customer Reg Test Failed");

	}

	@Test
	public void isSkip() {
		test = extent.createTest("Skip Test");
		throw new SkipException("Skipping the test case");
	}
		
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test Failed: "+methodName, ExtentColor.RED);
			test.fail(m);
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test Passed: "+methodName, ExtentColor.GREEN);
			test.pass(m);
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test Skipped: "+methodName, ExtentColor.YELLOW);
			test.skip(m);
		}
		
	}

}
