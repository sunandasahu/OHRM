package com.orangeHrm.testUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	//syntax:put the consturctor of that calss and write the .properties file code using try and catchb
	public BaseClass() throws IOException
	{
		
	try//executable code
	{
	 prop=new Properties();   //java.util
	
	FileInputStream fis=new FileInputStream("/Users/bhuban/Documents/sunanda_workspace/com.comname.projectname/configure.properties");//java.io
	//fis is used for connecting ur file of (.property)
	//fis will throw unhandeled exception.it can be handled by try and catch 
	prop.load(fis);//loading the file into prop varabale
	}
	catch(FileNotFoundException e)//unhandeled exception are handled by try and catch .user defined exception
	{
		e.printStackTrace();
	}
	}
	@BeforeClass
	public static void setup()
	{
		String browsername=prop.getProperty("browser");//is from .properties file
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("opera"))
		{
		WebDriverManager.operadriver().setup();
		driver=new OperaDriver();
		}
		else if(browsername.equalsIgnoreCase("ff"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
	}
		
//		/1st con.properties
//		2nd  base class has-->browser related vcode
//		3rd login pge--> webelemnet and actions
	
		
		@AfterClass
		
		public void tearDown()

	{
			driver.close();
	}
	
}

