package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadExcelFile {
	  XSSFWorkbook workb;
	
    public  void getdata() throws IOException
    {
	  String excelpath = System.getProperty("user.dir") +  "//TeatData//excelFile.xlsx"; 
	  FileInputStream file= new FileInputStream(excelpath);
	 workb  = new XSSFWorkbook(file);
	}
    public String getStringEmail(String sheetname,int row,int column)
    {
    	return  workb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
    }

}
