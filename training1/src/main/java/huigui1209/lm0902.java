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
			//�½�һ��Action��Ķ���Action��������mouse��keyboard
			Actions actions = new Actions(driver);
			//����ƶ����ض�Ԫ��
			actions.moveToElement(driver.findElement(By.id("J_SiteNavSeller")))
				//�ڵ�ǰԪ����ͣ������
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

	//	instanceofҲ��Java�ı����ؼ��֡������������ж�����߶����Ƿ�Ϊ���ұ����ʵ��������boolean���͵�����
}
