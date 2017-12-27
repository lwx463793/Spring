package huigui1209;

import java.lang.reflect.Proxy;

public class TestAnnoFactory {
	//创建一个代理工厂，返回一个接口
	public static ITestAnno build() {
		ITestAnno ta=(ITestAnno)Proxy.newProxyInstance(ITestAnno.class.getClassLoader(), 
				new Class[] {ITestAnno.class}, 
				new TestAnnoInvocationHandler());
		return ta;
	}

}
