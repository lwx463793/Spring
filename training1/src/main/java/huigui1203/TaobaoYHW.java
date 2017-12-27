package huigui1203;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;



public class TaobaoYHW {
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			//implicitilWait��WebDriver.Timeouts��һ�����������ص���һ��WebDriver.Timeouts���͵Ĳ�����
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			WebElement div = driver.findElement(By.cssSelector(".layer.clearfix > div"));
			//getLocation()��ȡ���Ԫ����page(x,y)
			/*Point point = div.getLocation();
			System.out.println(point);
			//JavascriptExecutor��FirefoxDriver��ʵ�֣�������ǿת�ɸ���������
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//window.scrollTo�ķ�����ʹ�����ܹ��Ƶ����Ӧ��Ԫ�ص�λ��
			jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,point.y);*/
			ScrollToElement(driver, div);
			WebElement element = driver.findElement(By.id("dg-item-tl-0"));
			System.out.println(element.getText());
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
	//ScrollToElement��һ���Զ���ķ���������ʹ�����ܹ��ƶ�����ӦԪ�ص�λ��
	public static void ScrollToElement(WebDriver driver, WebElement element) {
		Point point = element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollTo(arguments[0],arguments[1])",point.x,point.y);
	}
}
