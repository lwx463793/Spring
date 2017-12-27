package com.lm.echsop.test;

import org.testng.annotations.Test;

import com.lm.echsop.pages.IndexPage;
import com.lm.echsop.pages.UserPage;
import com.lm.ecshop.data.TestDataFactory;
import com.lm.framework.utils.BaseTest;

public class RegisterTest extends BaseTest{
	@Test(dataProvider="registerTestData_tips",dataProviderClass= TestDataFactory.class)
	public void testRegister(String contents,String expectedTexts) {
		String[] con_arr=contents.split(",");
		String[] exp_arr=expectedTexts.split(",");
		driver.get("http://localhost/ECShop/");
		IndexPage indexPage=new IndexPage(driver);
		indexPage.click_register_link();
		UserPage userPage=new UserPage(driver);
		for(int i=1;i<=con_arr.length;i++) {
			userPage.input_reg_info(i, con_arr[i-1]);
			
		}
		for(int i=1;i<exp_arr.length;i++) {
			userPage.assert_input_tip(i, exp_arr[i-1]);
			
		}
		
		
	}

	@Test
	public void testRegisterSuccess(String username,String email,String password,String con_password,String cellphone,String expectedText) {
		driver.get("http://localhost/ECShop/");
		IndexPage indexPage=new IndexPage(driver);
		indexPage.click_register_link();
		UserPage userPage=new UserPage(driver);
		userPage.input_reg_info(1,username);
		userPage.input_reg_info(1,email);
		userPage.input_reg_info(1,password);
		userPage.input_reg_info(1,con_password);
		userPage.input_reg_info(1,cellphone);
		userPage.click_reg_submit();
		userPage.assert_result_text(expectedText);
	}
	}
