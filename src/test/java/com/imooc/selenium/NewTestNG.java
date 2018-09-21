package com.imooc.selenium;

import org.openqa.selenium.By;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestNGListenerScreen.class})
public class NewTestNG extends BaseDriver{
  @Test
  public void test1() {
	  driver.get("https://www.baidu.com");
	  
	  System.out.print("case----1");
	  
  }
  
  @Test
  public void test2() {
	  driver.get("https://www.baidu.com");
	  driver.findElement(By.className("liufang"));
	  System.out.print("case----2");
  }
 
}
