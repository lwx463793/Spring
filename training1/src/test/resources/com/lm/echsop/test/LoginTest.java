package com.lm.echsop.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lm.echsop.pages.IndexPage;
import com.lm.echsop.pages.UserPage;
import com.lm.ecshop.data.TestDataFactory;
import com.lm.framework.utils.BaseTest;
import com.lm.framework.utils.Driverutils;

public class LoginTest extends BaseTest {
	
	
@Test(dataProviderClass=TestDataFactory.class,dataProvider="loginTestData")
public void testLogin_success(String username,String password,String expectedText) {
	
	//1������ҳ
	driver.get("http://localhost/ECShop/");
	
	//2�������¼����(�Ȱ�ҳ�����ʵ����)
	IndexPage indexPage=new IndexPage(driver);
	indexPage.click_login_link();
	
	//3����д�û���������
	UserPage userPage=new UserPage(driver);
	userPage.input_username(username);
	userPage.input_password(password);
	
	//4��������̵�¼��ť
	userPage.click_submit();
	
	//5���ж��Ƿ��¼�ɹ�
	if(username.equals("") || password.equals("")) {
		userPage.assert_alert_text(expectedText);
	}else {
		userPage.assert_result_text(expectedText);;
	}


}
}
