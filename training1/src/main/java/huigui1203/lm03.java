package huigui1203;







import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lm.framework.utils.Driverutils;


public class lm03 {
	//����alert
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("file:///D:/teststudy/seleniumstduy/1206/test/kuang.html");
			driver.findElement(By.id("a1")).click();
            //WebDriverWait��һ���࣬�̳���FluentWait����࣬����withMessage��������ʾ��diver����10�뻹û�ҵ�ʱ���᷵��һ�����ݣ��ķ���
			//���صĻ���FluentWait<T>�ķ��ͣ���ת��WebDriverWait
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10L).withMessage("����10�붼û�ҵ���sorry");
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

