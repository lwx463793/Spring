package huigui1209;



import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;
public class lm0901 {
	public static void main(String[] args) {
		WebDriver driver = Driverutils.getdriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");
			Thread.sleep(4000);
			//��a��ǩ��Ԫ�ؿ�����By.linkText(""),
			driver.findElement(By.linkText("[�������������·]")).click();
			Thread.sleep(4000);
			//��findElements(By by),�ҵ�ҳ�������к�ĳԪ�صģ���List<WebElement>���������
			List<WebElement> threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			System.out.println(threads.size());
			//get(0)����˼���ҵ�threads����ĵ�һ��������һ��E���ͣ��ٵ���findElement(By by)�ķ�����
			threads.get(0).findElement(By.xpath("tr/th/a[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("[�������������·]")).click();
			threads = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			threads.get(1).findElement(By.xpath("tr/th/a[3]")).click();
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
