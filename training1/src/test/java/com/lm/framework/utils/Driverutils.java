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
//Driverutils�������ṩservice�ĵ������������ṩƥ�䲻ͬ�������driver����
public class Driverutils {

	private static DriverService service;
	private static String browser;
	//������־����
	private static final Logger logger	=LogManager.getLogger();
	static{
		browser=System.getProperty("bwf.test.browser","firefox");
		logger.info("��ȡϵͳ����bwf.test.browser��ֵΪ"+browser);//ʹ����־��¼��ȡ�Ĳ���ֵ
		Config config=new Config("config.properties");
		String driverFile = config.getConfig("driver"); 
		logger.info("��ȡ�����ļ���driver���ڵ�·�����ļ�����ֵΪ"+driverFile);//ʹ����־��¼��ȡ�Ĳ���ֵ
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
			logger.error("δ֧�ָ������������ϵͳ����bwf.test.browser");
			throw new RuntimeException("δ֧�ָ������������ϵͳ����bwf.test.browser");	
		}
		try {	
			logger.error("driver��������");
			service.start();
		} catch (IOException e) {
			logger.error("δ�ܳɹ�����service��ԭ��Ϊ��"+e.getMessage());
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
		throw new RuntimeException("δ֧�ָ������������ϵͳ����bwf.test.browser");	
	}
	logger.info("capscapscaps"+caps);
driver=new RemoteWebDriver(service.getUrl(),caps);
	return driver;
	
}

public static void stopservice() {
	logger.info("driver����ֹͣ");
	service.stop();
}


}
