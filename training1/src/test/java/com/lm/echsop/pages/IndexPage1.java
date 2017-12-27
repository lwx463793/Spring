package com.lm.echsop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage1 {
	
	@FindBy(linkText="���¼")
	private WebElement login_btn;
	
	@FindBy(linkText="���ע��")
	private WebElement register_btn;
	
	//ʹ��ҳ�湤�������Լ�
	public IndexPage1(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	
	public void click_login_btn() {
		
		login_btn.click();
	}
	
	public void click_register_btn() {
		
		register_btn.click();
	}
	
}
