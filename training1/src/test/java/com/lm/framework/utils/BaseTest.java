package com.lm.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//�ü̳еķ�������ÿ������Ҫִ�еĻ����������ŵ�һ���������棬Ȼ����������ȥ�̳У��������Ա�֤ÿ������ĸɾ�
public class BaseTest {
	public WebDriver driver;
	
	//���������׼�ִ��֮�󣬹رշ���
	@AfterSuite
	public void closeService() {
		Driverutils.stopservice();
	}
	//��ÿ������ִ��֮ǰ�������»�ȡһ��driver
	@BeforeMethod
	public void initDriver() {
		Config config=new Config("config.properties");
		System.setProperty("bwf.test.browser", config.getConfig("bwf.test.browser"));
		driver=Driverutils.getdriver();
		
	}
	@AfterMethod
	public void  quitDriver() {
		driver.quit();
	}

}
