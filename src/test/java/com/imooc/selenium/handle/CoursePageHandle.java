package com.imooc.selenium.handle;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.page.CoursePage;

public class CoursePageHandle {
	public DriverBase driver;
	public CoursePage coursePage;
	public CoursePageHandle(DriverBase driver) {
		this.driver = driver;
		coursePage = new CoursePage(driver);
	}
	
	/**
	 * 点击立即购买按钮
	 * @throws IOException 
	 * */
	public String buyNow() throws IOException {
		String courseName = driver.getText(coursePage.getCourseNameElement());
		coursePage.click(coursePage.getBuyNowElement());		
		return courseName;
	}
	
	/**
	 * 点击加入购物车按钮
	 * */
	public void addCart() throws IOException{
		coursePage.click(coursePage.getAddCartElement());
	}
	
	/**
	 * 判断立即购买按钮是否存在
	 * @throws IOException 
	 * */
	public boolean assertCoursePage() throws IOException {
		return coursePage.assertElementIs(coursePage.getBuyNowElement());
	}
	
	
}
