package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUsers {
	public WebDriver driver;
	public RegisterUsers(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement titleaccount;
	
    @FindBy(linkText = "Sign out")
	WebElement signOut;
    
    
	
	public String verifyedaccount() {
	String username =	titleaccount.getText();
		return username;
		
	}
	public void clickOnSignOut()
	{
		signOut.click();
	}
	

}
