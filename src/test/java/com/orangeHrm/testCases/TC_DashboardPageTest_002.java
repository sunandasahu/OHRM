package com.orangeHrm.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangeHrm.pageObjects.DashboardPage;
import com.orangeHrm.pageObjects.LoginPage;
import com.orangeHrm.testUtility.BaseClass;

public class TC_DashboardPageTest_002 extends BaseClass
{
	    LoginPage lp ;
	    DashboardPage dp;
	public TC_DashboardPageTest_002() throws IOException {
		super();
		
	}
	@Test(priority=1)
	public void loginPageTest() throws Throwable
	{
    lp=new LoginPage();
	lp.enterUserName(prop.getProperty("username"));
	lp.enterPassword(prop.getProperty("password"));
	lp.clicklgnbtn();
	}
	
	@Test(priority=2)
	public void dashBoardPageTest() throws Exception
	{
		dp= new DashboardPage();
		dp.clickonPIMLink();
		dp.clickonAddEmployee();
		dp.enterFirstName(prop.getProperty("firstName"));
		dp.enterMiddleName(prop.getProperty("middleName"));
		dp.enterLastName(prop.getProperty("lastName"));
		dp.getEmpId();
		dp.clickonChkBox();
		dp.clickonSaveBtn();
	}
	

}
