package com.lm.framework.utils;



import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			Field field = tr.getTestClass().getRealClass().getField("driver");
			WrappedRemoteWebDriver driver = (WrappedRemoteWebDriver) field.get(tr.getInstance());
			String className = tr.getTestClass().getName();
			String methodName = tr.getName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
			String time = sdf.format(new Date());
			driver.takeScreenShot(className+"-"+methodName+"-"+time+".png");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}







/*public class TestListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {	
		try {
			Field field	=tr.getTestClass().getClass().getField("driver");
			WrappedRemoteWebDriver	driver  = (WrappedRemoteWebDriver)field.get(tr.getInstance());
			String className=tr.getTestClass().getName();
			String methodName=tr.getName();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
			String time=sdf.format(new Date());
			driver.takeScreenShot(className+"-"+methodName+"-"+time+".png");
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			file.renameTo(new File("abc.png"));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
	}
*/

