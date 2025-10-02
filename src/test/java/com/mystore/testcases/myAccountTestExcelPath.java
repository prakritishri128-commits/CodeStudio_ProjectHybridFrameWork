package com.mystore.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.RegisterUsers;
import com.mystore.pageobject.myAccountPage;
import com.mystore.utilities.ReadExcelFile;

public class myAccountTestExcelPath extends Baseclass01 {
	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{
		
		
		IndexPage indpage= new IndexPage(driver);
		indpage.clickOnSignIn();
		
		myAccountPage myaccount = new myAccountPage(driver);
		myaccount.enterCreateEmailAddress("ps080967@gmail.com");
		myaccount.clickonSubmit(); 
		
		AccountCreation accountCreate=new AccountCreation(driver);
		accountCreate.selectTitleMrs();
		accountCreate.selectTitleMr();
		accountCreate.enterCustomerFirstName("Prachiit");
		accountCreate.enterCustomerLastName("Guptaa");
		accountCreate.enterPassword("ps020923");
		accountCreate.clickOnRegister();
		
		RegisterUsers rsuser= new RegisterUsers(driver);
		 String username= rsuser.verifyedaccount();
		 Assert.assertEquals(username,"Prachiit Guptaa");
	}
	@Test
	public void verifyLogin() throws IOException
	{
		IndexPage pg1 = new IndexPage(driver);
		pg1.clickOnSignIn();
		 
		ReadExcelFile readxcel=new ReadExcelFile();
		readxcel.getdata();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String emailI  =readxcel.getStringEmail("Sheet1",1,0);
		String passw =readxcel.getStringEmail("Sheet1",1,1);
		String  usernme =readxcel.getStringEmail("Sheet1",1,2);
	
		myAccountPage myAcpg = new myAccountPage(driver);
    	myAcpg.enterEmailAddress(emailI);
		myAcpg.enterPassword(passw);
 
		myAcpg.clickSignIn();
		
		RegisterUsers rsuser= new RegisterUsers(driver);
		 String username1= rsuser.verifyedaccount();
 
		 if(username1.equals( usernme))
		 {
			 Assert.assertTrue(true);
			 
		 }else {
			captureScreenShot(driver,"verifyLogin");
			 Assert.assertTrue(false);
		 }
		 rsuser.clickOnSignOut();
	}
  
}
