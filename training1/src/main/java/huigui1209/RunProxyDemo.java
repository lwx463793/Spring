package huigui1209;

import java.lang.reflect.Proxy;

public class RunProxyDemo {
	public static void main(String[] args) {
		//��������ģʽ��һ����̬�ķ�����ֱ�ӵ��ã�����һ���ӿڣ��ѽӿ�ʵ����
		ITestAnno ta=TestAnnoFactory.build();
		//���ýӿڵķ���
		ta.sayHi();
	}

	
}
