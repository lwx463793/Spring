package huigui1203;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lm.framework.utils.Driverutils;


public class lm05 {
	//关于alert
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.baidu.com");
			driver.findElement(By.id("kw")).sendKeys("51testing");
			Thread.sleep(4000);
			driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
			String baiduWindow = driver.getWindowHandle();
			Thread.sleep(4000);
			driver.findElement(By.partialLinkText("51Testing")).click();
			Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			//handles.size(),返回的是当前窗口的个数
			System.out.println(handles.size());
			String testingWindow = "";
			//遍历当前的窗口，如果不是百度的窗口的话，就认为是测试的那个窗口，并且跳出整个循环
			for(String handle : handles) {
				if(!handle.equals(baiduWindow)) {
					testingWindow = handle;
					break;
				}
			}
			driver.switchTo().window(testingWindow);
			//打印当前浏览器的title	
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			//浏览器关闭
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			Driverutils.stopservice();
		}
	}
}
