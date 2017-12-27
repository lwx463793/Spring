package com.lm.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
//Driverutils类用于提供service的单例启动，并提供匹配不同浏览器的driver对象
public class Driverutils {

	private static DriverService service;
	private static String browser;
	//定义日志对象
	private static final Logger logger	=LogManager.getLogger();
	static{
		browser=System.getProperty("bwf.test.browser","firefox");
		logger.info("获取系统属性bwf.test.browser，值为"+browser);//使用日志记录获取的参数值
		Config config=new Config("config.properties");
		String driverFile = config.getConfig("driver"); 
		logger.info("获取配置文件中driver所在的路径和文件名，值为"+driverFile);//使用日志记录获取的参数值
		if("firefox".equalsIgnoreCase(browser)) {
			service=new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))
	            .usingAnyFreePort()
	            .usingDriverExecutable(new File(driverFile))
	            .build();}
		else if("chrome".equalsIgnoreCase(browser)) {
			service=new ChromeDriverService.Builder()
			.usingDriverExecutable(new File(driverFile))
            .usingAnyFreePort()
            .build();	
		}else  if ("ie".equalsIgnoreCase(browser)) {
			service=null;
		}else {
			logger.error("未支持该浏览器，请检查系统属性bwf.test.browser");
			throw new RuntimeException("未支持该浏览器，请检查系统属性bwf.test.browser");	
		}
		try {	
			logger.error("driver服务启动");
			service.start();
		} catch (IOException e) {
			logger.error("未能成功启动service，原因为："+e.getMessage());
			e.printStackTrace();
		}
	}
public static WebDriver getdriver() {
	WebDriver driver=null;
	DesiredCapabilities  caps=null;
	if("firefox".equalsIgnoreCase(browser)) {
		caps=DesiredCapabilities.firefox();
	}else if("chrome".equalsIgnoreCase(browser)) {
		caps=null;	
	}else  if ("ie".equalsIgnoreCase(browser)) {
		caps=null;
	}else {
		throw new RuntimeException("未支持该浏览器，请检查系统属性bwf.test.browser");	
	}
	logger.info("capscapscaps"+caps);
driver=new RemoteWebDriver(service.getUrl(),caps);
	return driver;
	
}

public static void stopservice() {
	logger.info("driver服务停止");
	service.stop();
}


}
