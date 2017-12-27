package huigui1209;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.lm.framework.utils.Driverutils;

import java.time.Duration;

public class lm0902 {
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			//新建一个Action类的对象，Action的属性有mouse、keyboard
			Actions actions = new Actions(driver);
			//鼠标移动到特定元素
			actions.moveToElement(driver.findElement(By.id("J_SiteNavSeller")))
				//在当前元素上停顿两秒
			.pause(Duration.ofSeconds(2L))
				.moveToElement(driver.findElement(By.id("J_SiteNavService")))
				.pause(Duration.ofSeconds(2L))
				.moveToElement(driver.findElement(By.id("J_SiteNavSitemap")))
				//A convenience method for performing the actions without calling build() first.
				.perform();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		} finally {
			Driverutils.stopservice();
			
		}
	}

	//	instanceof也是Java的保留关键字。它的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据
}
