package training1;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
//监听器，来识别哪些用例是执行成功的，哪些是失败的
public class MyTestListenner extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult arg0) {
		super.onTestFailure(arg0);
		System.out.println("F");
	}
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		super.onTestSuccess(arg0);
		System.out.println(".");
	}

}
