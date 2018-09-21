package com.imooc.selenium.business;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.handle.CoursePageHandle;

public class CoursePagePro {

	public DriverBase driver;
	public CoursePageHandle coursePageHandle;
	public CoursePagePro(DriverBase driver) {
		this.driver = driver;
		coursePageHandle = new CoursePageHandle(driver);
	}
	
	/**
	 * 执行立即购买操作
	 * @throws IOException 
	 * */
	public void buyCourseNow() throws IOException {
		if(coursePageHandle.assertCoursePage()) {			
			String courseText = coursePageHandle.buyNow();
//			System.out.println("课程页面课程名称："+courseText);	
		}
		
	}
}
