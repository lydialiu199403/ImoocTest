package com.imooc.selenium.testCase;

import com.imooc.selenium.base.DriverBase;

public class CaseBase {

	public DriverBase InitDriver(String browser) {
		return new DriverBase(browser);
	}
	
}
