package huigui1209;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)//ʲôʱ������
@Target(METHOD)//ע�ͼ�������
public @interface RunTime {
	public  int count() default 1;
		

}
