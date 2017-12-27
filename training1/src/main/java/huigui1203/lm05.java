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
	//����alert
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
			//handles.size(),���ص��ǵ�ǰ���ڵĸ���
			System.out.println(handles.size());
			String testingWindow = "";
			//������ǰ�Ĵ��ڣ�������ǰٶȵĴ��ڵĻ�������Ϊ�ǲ��Ե��Ǹ����ڣ�������������ѭ��
			for(String handle : handles) {
				if(!handle.equals(baiduWindow)) {
					testingWindow = handle;
					break;
				}
			}
			driver.switchTo().window(testingWindow);
			//��ӡ��ǰ�������title	
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			//������ر�
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			Driverutils.stopservice();
		}
	}
}
