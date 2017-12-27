package com.lm.ecshop.data;

import org.testng.annotations.DataProvider;

import com.lm.framework.utils.ReadExcel;
//°Ñ
public class TestDataFactory {
	@DataProvider(name="loginTestData")
	public static Object[][] getloginTestData() throws Exception{
		return ReadExcel.getDataFromExcel("loginTestData.xlsx", "Sheet1");
	}
	
	@DataProvider(name="registerTestData_tips")
	public static Object[][] getRegisterTestData_tips() throws Exception{
		Object[][] object = ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet1");
		return object;
	}
	@DataProvider(name="registerTestData_success")
	public static Object[][] getRegisterTestData_success() throws Exception{
		Object[][] object = ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet2");
		return object;
	}
}
