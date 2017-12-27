package com.lm.framework.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * ReadExcel��ʹ��POI��XSSFʵ��2007�汾�Ժ�excel�ļ���ָ��sheet�Ķ�ȡ
 * 
 */

public class ReadExcel {
/**
 *getDataFromExcel�ľ�̬�����ö�ȡ��resources�����excel�е����ݣ���һ��������Ϊͷ��Ϣ���Զ����� 
 * @param excelFileName��resourcesĿ¼�µ�excel��,����Ҫָ��·��
 * @param sheetname�����ȡҳ������
 * @return ��������Ϊ��λ���鷵��
 * @throws Exception 
 */
public static Object[][] getDataFromExcel(String excelFileName ,String sheetName) {
	
	Object [][] obj=null;
	//�������·���ж�ȡָ���ļ�����ȡ��������������excel��͵�ǰ�����(ReadExcel)ʵ��ͬһ��Ŀ¼��test�������棬����ֱ�����������������������excel�����ּ���
	InputStream  is=ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
	Workbook wb=null;
	Sheet sheet=null;
	try {
		wb=new XSSFWorkbook(is);//ͨ����������ȡExcel�ļ���workbook����
		sheet=wb.getSheet(sheetName);//��ȡָ����sheetҳ����
		int lastRowNum=sheet.getLastRowNum();//��ȡ���һ�еı��
		int lastCellNum=sheet.getRow(lastRowNum).getLastCellNum();// ��ȡ���һ����Ԫ��ı�ţ��кţ�����Ҫ��һ
		obj = new Object[lastRowNum][lastCellNum]; // ͨ��ѭ�����и�ֵ
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
