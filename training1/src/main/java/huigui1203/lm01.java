package huigui1203;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lm.framework.utils.Driverutils;

public class lm01 {
	
		public static void main(String[] args) {
			try {
			WebDriver driver = Driverutils.getdriver();
			//��̬--�����Ǹ����ӿڶ�������ñ�������ָ����������ʵ�����ʵ������
				driver.get("http://www.jd.com");
				//��cssѡ������λԪ�أ�
				//����ֱ�ӵ��ýӿ�����ķ���
				WebElement element = driver.findElement(By.cssSelector("#navitems-group1>li>a"));
				System.out.println(element.getText());
				//System.out.println(element.findElement(By.xpath("../..")).getTagName());
				//driver.findElement(By.cssSelector("//table/tbody/tr[last()]/td[4]/input")).click();
				Thread.sleep(2000);
				driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Driverutils.stopservice();
				
			}
			
			/*driver.get("http://localhost/test/link.html");
			WebElement link = driver.findElement(By.partialLinkText("������"));
			System.out.println(link.getText());*/
			
		}
		
		public static int choice(WebDriver driver, int index) {
			int price;
			WebElement check = driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input"));
			check.click();
			price = Integer.parseInt(check.findElement(By.xpath("../../td[3]")).getText());
			return price;
		}
	}



