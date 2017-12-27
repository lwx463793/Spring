package huigui1209;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)//什么时候运行
@Target(METHOD)//注释加在那里
public @interface RunTime {
	public  int count() default 1;
		

}
