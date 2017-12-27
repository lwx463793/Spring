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
			//implicitilWait是WebDriver.Timeouts的一个方法，返回的是一个WebDriver.Timeouts类型的参数，
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			WebElement div = driver.findElement(By.cssSelector(".layer.clearfix > div"));
			//getLocation()获取这个元素离page(x,y)
			/*Point point = div.getLocation();
			System.out.println(point);
			//JavascriptExecutor由FirefoxDriver来实现，将子类强转成父类对象接收
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//window.scrollTo的方法，使窗口能够移到相对应的元素的位置
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
	//ScrollToElement是一个自定义的方法，用来使窗口能够移动到相应元素的位置
	public static void ScrollToElement(WebDriver driver, WebElement element) {
		Point point = element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollTo(arguments[0],arguments[1])",point.x,point.y);
	}
}
