package huigui1209;

import java.lang.reflect.Proxy;

public class RunProxyDemo {
	public static void main(String[] args) {
		//工厂代理模式是一个静态的方法，直接调用，返回一个接口，把接口实例化
		ITestAnno ta=TestAnnoFactory.build();
		//调用接口的方法
		ta.sayHi();
	}

	
}
