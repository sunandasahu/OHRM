package com.orangeHrm.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsExa {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test =extent.createTest("GoogleSearch", "Validating the searchbox");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver 4");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(Status.INFO, "starting the test");
		driver.get("https://www.google.com/");
		test.pass("Nevigating to google home page");
		
		driver.findElement(By.name("q")).sendKeys("automation",Keys.ENTER);
		test.pass("entering values in searchbox and hit enter in keyboard");
		
		driver.close();
		test.pass("closing the browser");
		test.info("test completed");
		
		extent.flush();
		
	}

}
