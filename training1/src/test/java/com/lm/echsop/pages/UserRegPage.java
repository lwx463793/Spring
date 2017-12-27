package com.lm.echsop.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegPage {
	//����һ��driver
	private WebDriver driver;
	
	@FindBy(name="username1")
	private WebElement username_input;
	
	@FindBy(name="password")
	private WebElement password_input;
	
	@FindBy(name="submit")
	private WebElement submit_btn;
	
	public UserRegPage(WebDriver driver) {
		//�Ѵ�������driver��ֵ���Լ�������
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		}	
	public void input_username(String username) {
		username_input.sendKeys(username);
	}
	
	public void input_password(String password) {
		password_input.sendKeys(password);
	}
	
	public void click_submit() {
		submit_btn.click();
	}
	
	@FindBy(css="div.boxCenterList > div > p")
	private WebElement login_result_text;
	
	public void assert_result_text(String expectedText) {
		String actualText=login_result_text.getText();
		actualText.equalsIgnoreCase(expectedText);
	}
	
	/*public void assert_result_text(String expectedText) {
		String actualText = login_result_text.getText();
		assertEquals(actualText, expectedText);
	}
	*//**
	 * ���㣬���Ե����ľ�����ϵ������Ƿ������ֵƥ��
	 * @param expectedText ����������
	 */
	
	public void assert_alert_text(String expectedText) {
		Alert alert=driver.switchTo().alert();
		String actualText=alert.getText();
		actualText.equalsIgnoreCase(expectedText);
	}
	
	
	
	
	
	
	
	
	
	/*public void assert_alert_text(String expectedText) {
		Alert 	alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		assertTrue(actualText.contains(expectedText));
	}*/
	
	
}
