package com.lm.framework.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * ReadExcel类使用POI—XSSF实现2007版本以后excel文件中指定sheet的读取
 * 
 */

public class ReadExcel {
/**
 *getDataFromExcel的静态方法用读取在resources下面的excel中的数据，第一行数据作为头信息，自动跳过 
 * @param excelFileName在resources目录下的excel名,不需要指定路径
 * @param sheetname所需读取页的名称
 * @return 将数据作为二位数组返回
 * @throws Exception 
 */
public static Object[][] getDataFromExcel(String excelFileName ,String sheetName) {
	
	Object [][] obj=null;
	//从类加载路径中读取指定文件，获取其输入流。由于excel表和当前这个类(ReadExcel)实在同一个目录（test）的下面，所以直接用下面这个方法，秩序传入excel的名字即可
	InputStream  is=ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
	Workbook wb=null;
	Sheet sheet=null;
	try {
		wb=new XSSFWorkbook(is);//通过输入流读取Excel文件到workbook对象
		sheet=wb.getSheet(sheetName);//读取指定的sheet页对象
		int lastRowNum=sheet.getLastRowNum();//读取最后一行的编号
		int lastCellNum=sheet.getRow(lastRowNum).getLastCellNum();// 获取最后一个单元格的编号（列号），需要减一
		obj = new Object[lastRowNum][lastCellNum]; // 通过循环进行赋值
		for(int i=1;i<lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				String str=sheet.getRow(i).getCell(j).getStringCellValue();
			if(str.equalsIgnoreCase("<Empty>")) {
				obj[i-1][j]="";
			}else {
				obj[i-1][j]=str;
			}
			}
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}finally {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return obj;
}
}
