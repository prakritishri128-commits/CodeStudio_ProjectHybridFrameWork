package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class IndexPage {
	 public WebDriver driver;
	public IndexPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	@FindBy(linkText = "Sign in")
	WebElement singIn;
	
	public void clickOnSignIn()
	{
		singIn.click();
	}

}
