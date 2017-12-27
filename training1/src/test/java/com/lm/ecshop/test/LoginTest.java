package com.lm.ecshop.test;

import org.testng.annotations.Test;
import com.lm.echsop.pages.IndexPage;
import com.lm.echsop.pages.UserPage;
import com.lm.ecshop.data.TestDataFactory;
import com.lm.framework.utils.BaseTest;

public class LoginTest extends BaseTest {

	@Test(dataProvider="loginTestData",dataProviderClass=TestDataFactory.class)
	public void testLogin_success(String username,String password,String expectedText) {
		//1¡¢´ò¿ªÊ×Ò³
		driver.get("http://localhost/ECShop/");
		//2¡¢µã»÷µÇÂ¼Á´½Ó
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
		//3¡¢ÌîÐ´ÓÃ»§Ãû£¬ÃÜÂë
		UserPage userPage = new UserPage(driver);
		userPage.input_username(username);
		userPage.input_password(password);
		//4¡¢µã»÷Á¢¿ÌµÇÂ¼°´Å¥
		userPage.click_submit();
		//5¡¢ÅÐ¶ÏÊÇ·ñµÇÂ¼³É¹¦
		if(username.equals("") || password.equals("")) {
			userPage.assert_alert_text(expectedText);
		}else {
			userPage.assert_result_text(expectedText);
		}
	}
	
	
	
	
	
	}



