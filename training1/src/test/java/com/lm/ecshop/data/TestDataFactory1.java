package com.lm.ecshop.data;

import org.testng.annotations.DataProvider;

import com.lm.framework.utils.ReadExcel1;

public class TestDataFactory1 {
 @DataProvider(name="loginTestData")
 public static Object[][] getloginTestData(){
	 return ReadExcel1.getDataFromExcel("loginTestData.xlsx", "sheet1");
	 
 }
 
}
