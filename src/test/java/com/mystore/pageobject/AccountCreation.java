package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

public class AccountCreation {
	public WebDriver driver;
	public AccountCreation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(id = "id_gender2") //Title-Mrs
	WebElement titleMrs;

	@FindBy(id = "id_gender1") //Title-Mrs
	WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	WebElement custfirstName;

	@FindBy(id="customer_lastname")
	WebElement custlastName;

	@FindBy(id="passwd")
	WebElement password;

	@FindBy(xpath ="/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select/option[5]")
	WebElement datElement;

	@FindBy(id="submitAccount")
	WebElement register;
	
	 public void selectTitleMrs()
	{
		titleMrs.click();
	}

	public void selectTitleMr()
	{
		titleMr.click();
	}
	public void enterCustomerFirstName(String fname)
	{
		custfirstName.sendKeys(fname);
	}

	public void enterCustomerLastName(String lname)
	{
		custlastName.sendKeys(lname);
	}

	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickOnRegister()
	{
		register.click();
	}
	 
}
	 
	
 


