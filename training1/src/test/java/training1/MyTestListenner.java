package training1;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
//����������ʶ����Щ������ִ�гɹ��ģ���Щ��ʧ�ܵ�
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
