package com.lm.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;



public class BaseTest1 {
	
public WebDriver driver;
@AfterSuite
public void closeService() {
	Driverutils.stopservice();
}

//≥ı ºªØdriver
@BeforeMethod
public void initDriver() {
	Config config = new Config("config.properties");
	System.setProperty("bwf.test.browser", "firefox");
	driver=Driverutils.getdriver();
}
@AfterMethod
public void quitDriver() {
	driver.quit();
}
}
