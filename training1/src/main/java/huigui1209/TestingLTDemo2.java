package huigui1209;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.lm.framework.utils.Driverutils;

public class TestingLTDemo2 {
public static void main(String[] args) {
	WebDriver driver = Driverutils.getdriver();
	try {
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("http://bbs.51testing.com/");
		Thread.sleep(4000);
		TestLTPageIndex  indexPage=new TestLTPageIndex(driver);
		indexPage.forum_1_link.click();
		TestingLTPageForum1 forumPage=new TestingLTPageForum1(driver);
		forumPage.clickTopic(1);
		Thread.sleep(2000);
		driver.findElement(By.linkText("[软件测试新手上路]")).click();
		forumPage.clickTopic(2);
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

