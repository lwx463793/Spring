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
		//1���ҵ���ַ
		
		driver.get("http://localhost/ECShop/");
		
		
		//2��������̵�¼,�õ��ǹ������ķ�����ʵ����ҳ�����
		IndexPage1 indexpage1=new IndexPage1(driver);
		indexpage1.click_login_btn();
		
		//3�������û��������� 
		UserRegPage userregpage=new UserRegPage(driver);
		userregpage.input_username(username);
		userregpage.input_password(password);
	
		//4������ύ
		userregpage.click_submit();
		
	    //5���ж��Ƿ��¼�ɹ�
		if(username==""||password==""){
			userregpage.assert_alert_text(expectedText);
		}else {
			userregpage.assert_result_text(expectedText);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*//5���ж��Ƿ���ȷ
		if(username.equals("") || password.equals("")) {
			userregpage.assert_alert_text(expectedText);
		}else {
			userregpage.assert_result_text(expectedText);
		}
		*/
	}
	

}
