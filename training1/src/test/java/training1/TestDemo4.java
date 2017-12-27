package training1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo4 {
	//test�����������������еģ��һ�ѡ��һ������ʱ��ֻ��ִ�����Ӧ�ķ���
	
	@BeforeClass
	public  void beforeClassM() {
		System.out.println("----before class TestDemo4---");
	}
	@AfterClass
	public  void afterClassM() {
		System.out.println("----after class TestDemo4---");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("----before method in TestDemo4---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("----after method in TestDemo4---");
	}
	@Test
public  void myTest41Func() {
		System.out.println("----myTestFunc41");
	}
	@Test
	public  void myTest42Func2() {
			System.out.println("----myTestFunc42");
		}
}
