package huigui1209;

import java.lang.reflect.Method;

public class RunAnno {
		public static void main(String[] args) throws Exception, Exception {
			TestAnno  ta=new TestAnno();
			//�ѷ������ɶ���
			Method method=TestAnno.class.getDeclaredMethod("sayHi");
			//���ע����RunTime�ඨ��ģ���һ��RunTime��Ķ���������
			RunTime  rt=method.getAnnotation(RunTime.class);
			int count =rt.count();
				for(int i=0;i<count;i++) {
					method.invoke(ta);
					
				}
				
		}

}
