package huigui1209;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.lm.framework.utils.Driverutils;


public class PODemo {
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com");
			//利用工厂的模式，来帮我们打造一个TestLTPageIndex的对象，如果是new的话，就不能读出里面的注解
			TestLTPageIndex indexPage = PageFactory.initElements(driver, TestLTPageIndex.class);
			indexPage.forum_1_link.click();
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
