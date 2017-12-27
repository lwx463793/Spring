package training1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo3 {
	//test方法里面是无序运行的，右击选中一个方法时，只会执行相对应的方法
	@BeforeTest
	public  void beforeTestM() {
		System.out.println("----before Test2---");
	}
	@AfterTest
	public  void afterTestM() {
		System.out.println("----after Test2---");
	}
	@BeforeClass
	public  void beforeClassM() {
		System.out.println("----before class TestDemo3---");
	}
	@AfterClass
	public  void afterClassM() {
		System.out.println("----after class TestDemo3---");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("----before method in TestDemo3---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("----after method in TestDemo3---");
	}
	//表示方法执行的次数
	@Test(invocationCount=2)
public  void myTest31Func() {
		System.out.println("----myTestFunc31");
	}
	//
	@Test
	public  void myTest32Func2() {
			System.out.println("----myTestFunc32");
		}
}
