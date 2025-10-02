package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	public WebDriver driver;
	public myAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy( id ="email_create")
	WebElement createEmailId;
	
	@FindBy(id ="SubmitCreate")
	WebElement submitbutton;
	
	//already register details...
	
	@FindBy(id = "email") 
	WebElement registeredUsersEmail;
	
	@FindBy(id = "passwd") 
	WebElement registeredUsersPwd;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;
	
	public void enterCreateEmailAddress(String emailAdd) 
	{
		createEmailId.sendKeys(emailAdd);
	}
	public void clickonSubmit() 
	{
		 submitbutton.click();
	}
	//Already register users...
	public void enterEmailAddress(String emailAdd) 
	{
		registeredUsersEmail.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) 
	{
		registeredUsersPwd.sendKeys(pwd);
	}

	public void clickSignIn()
	{
		submitLogin.click();
	}
}
