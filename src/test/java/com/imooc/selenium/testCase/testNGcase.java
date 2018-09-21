package com.imooc.selenium.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGcase {

	@BeforeClass
	public void test01() {
		System.out.println("BeforeClass--->test01");
	}
	
	@BeforeMethod
	public void test02() {
		System.out.println("BeforeMethod--->test02");
	}
	@Test
	public void test0001() {
		System.out.println("Test--->test0001");
	}
	@Test
	public void test0002() {
		System.out.println("Test--->test0002");
	}
	
	@AfterMethod
	public void test04() {
		System.out.println("AfterMethod--->test04");
	}
	@AfterClass
	public void test05() {
		System.out.println("AfterClass--->test05");
	}
}
