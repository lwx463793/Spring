package com.lm.ecshop.test;

import org.testng.annotations.Test;
import com.lm.echsop.pages.IndexPage;
import com.lm.echsop.pages.UserPage;
import com.lm.ecshop.data.TestDataFactory;
import com.lm.framework.utils.BaseTest;

public class LoginTest extends BaseTest {

	@Test(dataProvider="loginTestData",dataProviderClass=TestDataFactory.class)
	public void testLogin_success(String username,String password,String expectedText) {
		//1������ҳ
		driver.get("http://localhost/ECShop/");
		//2�������¼����
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
		//3����д�û���������
		UserPage userPage = new UserPage(driver);
		userPage.input_username(username);
		userPage.input_password(password);
		//4��������̵�¼��ť
		userPage.click_submit();
		//5���ж��Ƿ��¼�ɹ�
		if(username.equals("") || password.equals("")) {
			userPage.assert_alert_text(expectedText);
		}else {
			userPage.assert_result_text(expectedText);
		}
	}
	
	
	
	
	
	}



