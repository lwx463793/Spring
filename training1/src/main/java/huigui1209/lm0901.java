package huigui1209;



import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;
public class lm0901 {
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");
			Thread.sleep(4000);
			//带a标签的元素可以用By.linkText(""),
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			Thread.sleep(4000);
			//用findElements(By by),找到页面上所有含某元素的，用List<WebElement>对象存起来
			List<WebElement> threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			System.out.println(threads.size());
			//get(0)的意思是找到threads里面的第一个，返回一个E类型，再调用findElement(By by)的方法，
			threads.get(0).findElement(By.xpath("tr/th/a[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			threads.get(1).findElement(By.xpath("tr/th/a[3]")).click();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		} finally {
			Driverutils.stopservice();
			
		}
	}
}
