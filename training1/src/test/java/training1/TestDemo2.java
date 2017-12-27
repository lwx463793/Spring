package training1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo2 {
	@BeforeClass
	public  void beforeClassM() {
		System.out.println("----before class TestDemo2---");
	}
	@AfterClass
	public  void afterClassM() {
		System.out.println("----after class TestDemo2---");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("----before method in TestDemo2---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("----after method in TestDemo2---");
	}
	//test方法里面是无序运行的，右击选中一个方法时，只会执行相对应的方法
	@Test(groups= {"firstleve"})
     public  void myTest21Func() {
		System.out.println("----myTestFunc21");
	}
	@Test(groups= {"secondleves"})
	public  void myTest22Func2() {
			System.out.println("----myTestFunc22");
		}
}
