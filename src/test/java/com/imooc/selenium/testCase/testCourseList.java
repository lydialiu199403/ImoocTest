package com.imooc.selenium.testCase;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.imooc.selenium.base.DriverBase;

@Test
public class testCourseList extends CaseBase{
	public DriverBase driver;
	public testCourseList() {
		this.driver = InitDriver("chrome");
	}
	
	public void CourseList(){
		driver.get("https://coding.imooc.com/");
		driver.maxWindow();
		List<String> listString = this.listElement();
		for(int i=0; i<listString.size();i++) {			
			driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
			driver.back();
			
		}		
	}
	
	/**
	 * 获取所有课程的list
	 * */
	public List<String> listElement(){
		List<String> listString = new ArrayList<String>();
		WebElement courseList = driver.findElement(By.className("shizhan-course-list"));
		List<WebElement> listElement = courseList.findElements(By.className("shizhan-course-box"));
		for(WebElement element:listElement) {
			listString.add(element.findElement(By.className("shizan-name")).getText());
		}
		return listString;
	}

}
