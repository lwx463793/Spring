package huigui1203;







import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lm.framework.utils.Driverutils;


public class lm03 {
	//关于alert
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("file:///D:/teststudy/seleniumstduy/1206/test/kuang.html");
			driver.findElement(By.id("a1")).click();
            //WebDriverWait是一个类，继承了FluentWait这个类，调用withMessage（用来显示当diver找了10秒还没找到时，会返回一个内容）的方法
			//返回的还是FluentWait<T>的泛型，再转成WebDriverWait
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10L).withMessage("找了10秒都没找到，sorry");
			//?
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
//			alert.sendKeys("123");
			alert.accept();
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}

