package com.lm.ecshop.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.lm.echsop.pages.IndexPage1;
import com.lm.echsop.pages.UserRegPage;
import com.lm.ecshop.data.TestDataFactory1;
import com.lm.framework.utils.BaseTest1;

public class LoginTest1  extends BaseTest1{
	
	@Test(dataProviderClass=TestDataFactory1.class,dataProvider="loginTestData")
	public void testlogin_success(String password,String username,String expectedText) throws InterruptedException {
		//1、找到网址
		
		driver.get("http://localhost/ECShop/");
		
		
		//2、点击立刻登录,用的是构造器的方法来实例化页面对象
		IndexPage1 indexpage1=new IndexPage1(driver);
		indexpage1.click_login_btn();
		
		//3、输入用户名、密码 
		UserRegPage userregpage=new UserRegPage(driver);
		userregpage.input_username(username);
		userregpage.input_password(password);
	
		//4、点击提交
		userregpage.click_submit();
		
	    //5、判断是否登录成功
		if(username==""||password==""){
			userregpage.assert_alert_text(expectedText);
		}else {
			userregpage.assert_result_text(expectedText);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*//5、判断是否正确
		if(username.equals("") || password.equals("")) {
			userregpage.assert_alert_text(expectedText);
		}else {
			userregpage.assert_result_text(expectedText);
		}
		*/
	}
	

}
