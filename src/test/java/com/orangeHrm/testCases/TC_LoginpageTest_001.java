package com.orangeHrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHrm.pageObjects.LoginPage;
import com.orangeHrm.testUtility.BaseClass;

public class TC_LoginpageTest_001 extends BaseClass {
	
	LoginPage lp ;

	public TC_LoginpageTest_001() throws IOException 
	{
		super();
	}
		
		@Test(priority=1)
		public void loginPageTest() throws Throwable
		{
	    lp=new LoginPage();
		lp.enterUserName(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		lp.clicklgnbtn();
		
		String title = lp.gettitle();
		
		Assert.assertEquals(title,"Dashboard");
		}

	
}
