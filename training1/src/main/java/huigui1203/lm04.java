package huigui1203;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lm.framework.utils.Driverutils;



public class lm04 {
	//关于alert
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("file:///D:/teststudy/seleniumstduy/1206/test/frame.html");
			//switchTo()是你用来打开特定的frame或者是Windows来，返回的是WebDriver.TargetLocator的类型，再调用frame(WebElement frameElement)
			//的方法，Select a frame using its previously located WebElement.，用塔当前定位的元素找到一个frame，返回一个Webdriver的类型
			driver.switchTo().frame(driver.findElement(By.xpath("//p[@id='mid']/iframe[2]")));
			//在找到的frame中，再找到ID为"kw"的框，再发送关键字
			driver.findElement(By.id("kw")).sendKeys("123");
			Thread.sleep(2000);
			//switchTo().defaultContent();这个方法从iframe,回到主frame，
			driver.switchTo().defaultContent();
			driver.findElement(By.id("kg")).sendKeys("ddd");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driverutils.stopservice();
			
		}
	}
}
