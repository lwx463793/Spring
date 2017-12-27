package huigui1209;

import java.lang.reflect.Method;

public class RunAnno {
		public static void main(String[] args) throws Exception, Exception {
			TestAnno  ta=new TestAnno();
			//把方法看成对象
			Method method=TestAnno.class.getDeclaredMethod("sayHi");
			//这个注解是RunTime类定义的，用一个RunTime类的对象来接收
			RunTime  rt=method.getAnnotation(RunTime.class);
			int count =rt.count();
				for(int i=0;i<count;i++) {
					method.invoke(ta);
					
				}
				
		}

}
