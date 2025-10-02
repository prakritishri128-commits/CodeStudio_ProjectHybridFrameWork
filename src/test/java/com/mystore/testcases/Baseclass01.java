package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ConfigRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass01 {
	ConfigRead configread = new ConfigRead();
    String url =configread.getbaseUrl();
    String browser =configread.getbrowser();
    public static WebDriver driver;
    
   @BeforeClass
   public void setup()
   {
   	 switch(browser.toLowerCase())
   	 {
   	 case "chrome": 
//   		 WebDriverManager.chromedriver().setup();
   		driver = new ChromeDriver();
   		driver.manage().window().maximize();
   		 break;
   	 case "firefox":
   		 WebDriverManager.firefoxdriver().setup();
   		 driver = new FirefoxDriver();
   		 break;
   	case "msedge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;

   	 default:
			driver = null;
			break;
   	 }
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
   	driver.get(url);
   }
   
   
   @AfterClass
   public void tearDown()
   {
   	driver.close();
   	driver.quit();
   }
   
  public void captureScreenShot(WebDriver driver,String testName) throws IOException
  {
	   
	  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File desFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + testName  +".png");
	  FileUtils.copyFile(srcFile,desFile);
  }
   }



