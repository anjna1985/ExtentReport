package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TESTNGl  implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " +result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " +result.getName());
		//screenshot
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Finished: " +context.getName());
		
	}

}
