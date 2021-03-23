package aequilibrium;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner extends Utility implements ITestListener {
	
	@ Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED TEST");
		failed();
	}

}
