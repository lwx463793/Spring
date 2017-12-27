package huigui1203;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;



public class lm02 {
	public static void main(String[] args) {
		//javascript & jquery
		WebDriver driver = Driverutils.getdriver();
		try {
			//���ӵȴ�
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://www.jd.com");
			//driver.getWindowHandle()�����������ʲô���أ�
			//�������ֻ�Ƿ���һ���ַ������ѣ�����ַ����ǵ�ǰ���ڱ�driver���Ƶ���������ڵ�ʶ���
			System.out.println(driver.getWindowHandle());
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;
			Thread.sleep(4000);
			//List<WebElement>���WebElement����ļ���//����javascript �е�document�ķ�������ȡ��ӦԪ��//?
			List<WebElement> list = (List<WebElement>) jse.executeScript("return document.getElementsByTagName('tr');");
			System.out.println(list);*/
			
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/label")).click();
			//switchTo(),���ص���һ��WebDriver.TargetLocator���ֽӿڣ��ٵ��������activeElement��Ѱ�ҵ�ǰ��Ծ��Ԫ�أ��ģ����ص���һ��WebElement���࣬�ٵ���
			//sendKeys("25")�ķ���
			driver.switchTo().activeElement().sendKeys("25"); 
           //driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/input")).sendKeys("25");
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).click();
//			((JavascriptExecutor)driver).executeScript("document.getElementById('price').innerText=1234");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
			
		}
	}
}
