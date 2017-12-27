package com.lm.framework.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel1 {
	public static Object[][] getDataFromExcel(String excelFileName,String sheetName){
		Object[][] obj=null;
		InputStream is =ReadExcel1.class.getClassLoader().getResourceAsStream(excelFileName);
	Workbook wb=null;
	Sheet sheet =null;
	
	try {
		wb=new XSSFWorkbook(is);//通过输入流读取Excel文件到workbook对象
		sheet=wb.getSheet(sheetName);//获取指定的sheet页对象
		
		int lastRowNum=sheet.getLastRowNum();
		
//获取最后一个单元格的编号（列号），需要减一
		int lastCellNum=sheet.getRow(lastRowNum).getLastCellNum();
		obj = new Object[lastRowNum][lastCellNum]; //通过循环进行赋值
		for(int i = 1; i <= lastRowNum; i++) {
			for(int j = 0; j < lastCellNum; j++) {
				String str = sheet.getRow(i).getCell(j).getStringCellValue();
				if(str.equalsIgnoreCase("<Empty>")) {
					obj[i-1][j] = "";
				}else {
					obj[i-1][j] = str;
				}
			} 
		}
	}catch (IOException e) {
		
		e.printStackTrace();
	}finally {
		try {
			if(wb==null) {
				
				System.err.println("nnnnnnnnnn");
			}
			else {
				wb.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	return obj;
	}
	
}