package huigui1203;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils {
	
	private static DriverService service;
	private static String browser;
	
	
	static {
		browser = System.getProperty("bwf.test.browser", "firefox"); // ��ȡbwf.test.browserϵͳ���ԣ����δ���ã���Ĭ��Ϊfirefox
		/*
		 * ����browser�������������ͣ��ֱ𴴽�DriverService����Ŀǰchrome��ie��δ�깤
		 */
		if("firefox".equalsIgnoreCase(browser)) {
			service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"))) // ָ����������ִ���ļ�
				.usingAnyFreePort() // ָ��ʹ����һ���ö˿�
				.usingDriverExecutable(new File("E:\\tools\\seleniumForStudents\\geckodriver.exe")) // ָ��driver���������λ��
				.build(); // ��Builder��������DriverService����
		}else if("chrome".equalsIgnoreCase(browser)) {
			// not yet implemenent
			service = null;
		}else if("ie".equalsIgnoreCase(browser)){
			// not yet implemenent
			service = null;
		}else {
			throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
		}
		try {
			service.start(); // ����service
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



/**
 * getDriver��̬����������ʹ�����ṩ����Ļ�ȡ��ͬ���������driver����
 * @return driver
 */
public static WebDriver getDriver() {
	
	WebDriver driver = null;
	DesiredCapabilities caps = null;
	/*
	 * ����browser��ֵ�ж�������browser����
	 */
	if("firefox".equalsIgnoreCase(browser)) {
		caps = DesiredCapabilities.firefox();
	}else if("chrome".equalsIgnoreCase(browser)) {
		// not yet implemenent
		caps = null;
	}else if("ie".equalsIgnoreCase(browser)){
		// not yet implemenent
		caps = null;
	}else {
		throw new RuntimeException("δ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
	}
	driver = new RemoteWebDriver(service.getUrl(), caps);
	return driver;
}
/**
 * ֹͣ����
 */
public static void stopService() {
	service.stop();
}
}
