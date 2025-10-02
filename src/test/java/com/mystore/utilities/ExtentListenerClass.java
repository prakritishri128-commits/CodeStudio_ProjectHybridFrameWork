package com.mystore.utilities;

 

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter httSparkReporter;
	ExtentReports reports;
	ExtentTest test;
	 
	
	public void configureReports()
	{
		ConfigRead conRead = new ConfigRead();
		
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String repotName = "HybridFrameworkReports_" + timeStamp + ".html";
		 
		httSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Report//" + repotName);
	   reports = new ExtentReports();
	   reports.attachReporter(httSparkReporter); 
	   
	   reports.setSystemInfo("Machine:","testc1");
       reports.setSystemInfo("os","Windows 11");
       reports.setSystemInfo("browser",conRead.getbrowser());
       reports.setSystemInfo("user","rachita");
       
       httSparkReporter.config().setDocumentTitle("Extent listener Reports");
       httSparkReporter.config().setReportName("this is First Reports");
	   httSparkReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	 System.out.println("name of test method Success"  + result.getName());
	 test = reports.createTest(result.getName());
	 test.log(Status.PASS,MarkupHelper.createLabel("Name of the success method"  + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	 	System.out.println("name of test method failed:"  +  result.getName()); 
	 	test = reports.createTest(result.getName());
	 	test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed testmethod:"  + result.getName() , ExtentColor.RED));
	
	 	String screenshotpathString = System.getProperty("user.dir") + "\\Screenshot\\"  + result.getName() + ".png";
	    
	 	File screenshotfile = new File(screenshotpathString);
	 	if(screenshotfile.exists())
	 	{
	 		test.fail("Capture screenshot is:" + test.addScreenCaptureFromPath(screenshotpathString));
	 	}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("name of test method skipped:"  +  result.getName()); 
	 	test = reports.createTest(result.getName());
	 	test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped testmethod:"  + result.getName() , ExtentColor.YELLOW));	 
	}
	@Override
	public void onStart(ITestContext context){
		configureReports();
		System.out.println("on stsrt methods invokes......");
	}
		// TODO Auto-generated method stub
		 
	 
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish method invoked,.....");
		reports.flush();
	}
		// TODO Auto-generated method stub
		 
	}


