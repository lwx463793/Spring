package com.lm.echsop.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * UserPage�����ڶ���user.phpҳ���Ԫ�غͷ���
 * @author liumie
 *
 */

public class UserPage {
	
	//���û�ע��ҳ���е�5��������ü�������ʾ
	List<WebElement> reg_input_list=new ArrayList<>();
	private WebDriver driver;
	
    //��¼ҳ�棬�û����������
	@FindBy(name="username")
	private WebElement username_input;
	
	//��¼ҳ�棬����������
	@FindBy(name="password")
	private WebElement password_input;
	
	//��¼ҳ�棬������¼��ť
	@FindBy(name="submit")
	private WebElement submit_button;	
	
	/**
	 * �ύ��¼�����ʾ��Ϣ
	 */
	@FindBy(css="div.boxCenterList>div>p")
	private WebElement login_result_text;
	
	
	
	//ע��ҳ�棬ע���û���
	@FindBy(id="username")
	private WebElement reg_username_input;
	
	//ע��ҳ�棬ע������
	@FindBy(id="email")
	private WebElement reg_email_input;
	
	//ע��ҳ�棬ע������
	@FindBy(id="password1")
	private WebElement reg_password_input;
	
	//ע��ҳ�棬ȷ������
	@FindBy(id="conform_password")
	private WebElement reg_confirm_password_input;
	
	//ע��ҳ�棬ע���ֻ�����
	@FindBy(name="extend_field5")
	private WebElement reg_cellphone_input;
	
	/**
	 * ע���ύ��ť
	 */
	@FindBy(name="Submit")
	private WebElement reg_submit_btn;
	/**
	 * UserPage�����Ĺ�������ʹ��ҳ�湤���ķ�ʽ�������Լ�
	 */
	public UserPage(WebDriver driver) {
		reg_input_list.add(reg_username_input);
		reg_input_list.add(reg_email_input);
		reg_input_list.add(reg_password_input);
		reg_input_list.add(reg_confirm_password_input);
		reg_input_list.add(reg_cellphone_input);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * �ڵ�¼ҳ�棬�û��������������ָ�����û����ַ���
	 * @param username ָ��������û����ַ���
	 */
	public void input_username	(String username ) {
		username_input.sendKeys(username);
		
	}
	/**
	 * �ڵ�¼ҳ�棬�û����������������ָ�����������
	 * @param password ָ��������������
	 */
	public void input_password	(String password ) {
			password_input.sendKeys(password);	
		}
	
	  /**
	  * �ڵ�¼ҳ�棬����ύ��ť
	  */
		public void click_submit() {
			submit_button.click();	
		}
	
		/**
		 * �������ע�ᰴť
		 */
		public void click_reg_submit() {
			reg_submit_btn.click();
		}
		/**
		 * ���㣬�����Ƿ���ʾָ���ĵ�¼�����ʾ�ı�
		 * @param expectedText ������ʾ���ı�
		 */
		public void assert_result_text(String expectedText) {
			String actualText = login_result_text.getText();
			assertEquals(actualText, expectedText);
		}
		
		
		/**
		 * ���㣬���Ե����ľ�����ϵ������Ƿ������ֵƥ��
		 * @param expectedText ����������
		 */	
		public void assert_alert_text(String expectedText) {
			Alert alert=driver.switchTo().alert();
			String actualText=alert.getText();
			assertTrue(actualText.contains(expectedText));
			
		}
		/**
		 * ��ע����Ϣ������ָ������
		 * @param index �ڼ����������1��ʼ
		 * @param cotent ���������
		 */
		public void input_reg_info(int index,String content ) {
			reg_input_list.get(index-1).sendKeys(content);
		}
		
		
		/**
		 * ���㣬���������Ƿ����Ҫ��
		 * @param index �ڼ����������1��ʼ
		 * @param expectedText ��ʾ�������ı�
		 */
		public void  assert_input_tip(int index,String expectedText) {
			String actual=reg_input_list.get(index-1).findElement(By.xpath("../span")).getText();
			assertTrue(actual.contains(expectedText));
		}
}