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
			//���ù�����ģʽ���������Ǵ���һ��TestLTPageIndex�Ķ��������new�Ļ����Ͳ��ܶ��������ע��
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
