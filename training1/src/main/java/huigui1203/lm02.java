package huigui1203;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;



public class lm02 {
	public static void main(String[] args) {
		//javascript & jquery
		WebDriver driver = Driverutils.getdriver();
		try {
			//隐视等待
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://www.jd.com");
			//driver.getWindowHandle()，这个方法有什么用呢？
			//这个方法只是返回一个字符串而已，这个字符串是当前正在被driver控制的浏览器窗口的识别号
			System.out.println(driver.getWindowHandle());
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;
			Thread.sleep(4000);
			//List<WebElement>存放WebElement对象的集合//调用javascript 中的document的方法来获取相应元素//?
			List<WebElement> list = (List<WebElement>) jse.executeScript("return document.getElementsByTagName('tr');");
			System.out.println(list);*/
			
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/label")).click();
			//switchTo(),返回的是一个WebDriver.TargetLocator这种接口，再调用里面的activeElement（寻找当前活跃的元素）的，返回的是一个WebElement的类，再调用
			//sendKeys("25")的方法
			driver.switchTo().activeElement().sendKeys("25"); 
           //driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/input")).sendKeys("25");
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).click();
//			((JavascriptExecutor)driver).executeScript("document.getElementById('price').innerText=1234");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}
