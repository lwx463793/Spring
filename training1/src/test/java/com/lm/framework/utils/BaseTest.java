package com.lm.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//用继承的方法，把每个类需要执行的基础方法都放到一个父类里面，然后在用子类去继承，这样可以保证每个子类的干净
public class BaseTest {
	public WebDriver driver;
	
	//整个测试套件执行之后，关闭服务
	@AfterSuite
	public void closeService() {
		Driverutils.stopservice();
	}
	//在每个方法执行之前，都重新获取一个driver
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
