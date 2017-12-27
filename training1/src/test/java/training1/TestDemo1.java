package training1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo1 {
	@BeforeSuite
	public  void beforeSuiteM() {
		System.out.println("----before Suite---");
	}
	@AfterSuite
	public  void afterSuiteM() {
		System.out.println("----After Suite---");
	}
	@BeforeTest
	public  void beforeTestM() {
		System.out.println("----before Test1---");
	}
	@AfterTest
	public  void afterTestM() {
		System.out.println("----after Test1---");
	}
	@BeforeClass
	public  void beforeClassM() {
		System.out.println("----before class TestDemo1---");
	}
	@AfterClass
	public  void afterClassM() {
		System.out.println("----after class TestDemo1---");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("----before method in TestDemo1---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("----after method in TestDemo1---");
	}
	//test�����������������еģ��һ�ѡ��һ������ʱ��ֻ��ִ�����Ӧ�ķ���
	@Test(groups= {"firstleve"})
public  void myTest11Func() {
		System.out.println("----myTestFunc11");
	}
	//dependsOnGroups����ִ�У�����������һ����ִ���꣬��ִ��
	//groups= {"secondleves"},������ķ������з���
	//(enabled=false),��ĳ��������ע�͵���
	//dependsOnMethods={""},������ĳ��������ִ�У�Ȼ����ִ�д˷���
	@Test(groups= {"secondleves"}, dependsOnGroups= {"firstleve"})
	public  void myTest12Func2() {
			System.out.println("----myTestFunc12");
		}
}
