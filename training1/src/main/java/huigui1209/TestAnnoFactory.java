package huigui1209;

import java.lang.reflect.Proxy;

public class TestAnnoFactory {
	//����һ��������������һ���ӿ�
	public static ITestAnno build() {
		ITestAnno ta=(ITestAnno)Proxy.newProxyInstance(ITestAnno.class.getClassLoader(), 
				new Class[] {ITestAnno.class}, 
				new TestAnnoInvocationHandler());
		return ta;
	}

}
