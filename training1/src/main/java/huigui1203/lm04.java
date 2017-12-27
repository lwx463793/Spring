package huigui1203;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lm.framework.utils.Driverutils;



public class lm04 {
	//����alert
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("file:///D:/teststudy/seleniumstduy/1206/test/frame.html");
			//switchTo()�����������ض���frame������Windows�������ص���WebDriver.TargetLocator�����ͣ��ٵ���frame(WebElement frameElement)
			//�ķ�����Select a frame using its previously located WebElement.��������ǰ��λ��Ԫ���ҵ�һ��frame������һ��Webdriver������
			driver.switchTo().frame(driver.findElement(By.xpath("//p[@id='mid']/iframe[2]")));
			//���ҵ���frame�У����ҵ�IDΪ"kw"�Ŀ��ٷ��͹ؼ���
			driver.findElement(By.id("kw")).sendKeys("123");
			Thread.sleep(2000);
			//switchTo().defaultContent();���������iframe,�ص���frame��
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
