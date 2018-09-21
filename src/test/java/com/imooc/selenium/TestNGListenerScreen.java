package com.imooc.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListenerScreen extends TestListenerAdapter{

	public void onTestFailure(ITestResult tr) {
		System.out.println("该方法运行失败");	
		BaseDriver base = (BaseDriver)tr.getInstance();
		WebDriver driver = base.getDriver();
		
	
		try {
			takeScreenShot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onTestFailure(tr);
	}
	
	/**
	 * 失败截图
	 * @throws IOException 
	 * */
	 public void takeScreenShot(WebDriver driver) throws IOException {
		 	
			long date = System.currentTimeMillis();
			String path = String.valueOf(date);
			String currentPath = System.getProperty("user.dir");
			path = path+".png";
			String screenPath = currentPath+"/"+path;
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenPath));
			
		}
}
