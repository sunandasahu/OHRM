package com.orangeHrm.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.testUtility.BaseClass;

public class DashboardPage extends BaseClass
{
  public DashboardPage() throws Exception
  {
	  PageFactory.initElements(driver, this);
	  
  }
  @FindBy(xpath = "//*[contains(text(),'PIM')]" )
	WebElement pimLink;
  Actions act= new Actions(driver);
  
  
  @FindBy(xpath= "//a[@id='menu_pim_addEmployee']")
  WebElement addEmployee;
  
  @FindBy(xpath="//input[@name='firstName']")
  WebElement firstName;
  
  @FindBy(xpath="//input[@name='middleName']")
  WebElement middleName;
  
  @FindBy(xpath="//input[@name='lastName']")
  WebElement lastName;
  
  @FindBy(xpath="//input[@name='employeeId']")
  WebElement employeeId;
  
  @FindBy(xpath="//input[@id='chkLogin']")
  WebElement logInChkBox;
  
  @FindBy(xpath="//input[@id='btnSave']")
  WebElement saveBtn;


  public void clickonPIMLink(){
	
	  act.moveToElement(pimLink).build().perform();
}
  public void clickonAddEmployee()
  {
	  addEmployee.click();  
  }
  
  public void enterFirstName(String fName)
  {
	  firstName.sendKeys("fname"); 
  }
  
  public void enterMiddleName(String mName)
  {
	  middleName.sendKeys("mName");;  
  }
  
  public void enterLastName(String lName)
  {
	  lastName.sendKeys("lName");;  
  }
  
  public String getEmpId()
  {
	  return employeeId.getText();
  }
  
  public void clickonChkBox()
  {
	  logInChkBox.click();
  }
  
  public void clickonSaveBtn()
  {
	  saveBtn.click();
  }




}