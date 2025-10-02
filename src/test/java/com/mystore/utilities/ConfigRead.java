package com.mystore.utilities;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
	Properties properties;
	String path ="C:\\Users\\INDIAN\\eclipse-workspace\\HybridFramework_Mam\\configuration\\config";
	public ConfigRead()   
	{
		properties = new Properties();
		 try {
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public String getbaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}
	public String getbrowser()
	{
		String browserN = properties.getProperty("browser"); 
	    if(browserN != null)
	    	return browserN;
	    else
	    	throw new RuntimeException("Browser isnot specified in config file.");
	}
}

