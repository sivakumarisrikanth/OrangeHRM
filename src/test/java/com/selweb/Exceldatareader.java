package com.selweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatareader {
	public XSSFWorkbook xsw;
	public XSSFSheet xss;
	
	public Exceldatareader() {
		File src=new File("E:\\sivakumari\\Trainingproject\\TestDataForExel\\Excelsheet.xlsx");
		
			FileInputStream fis;
			try {
				fis = new FileInputStream(src);
			
			
				xsw=new XSSFWorkbook(fis);
			} catch (IOException e) {
				System.out.println("file is not found");
			}
	

		
	}
	          public String getstringdata(String sheetname,int rownum,int cellnum){
			return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	    	   
	       }
	       public double getnumericdata(String sheetname,int rownum,int cellnum) {
			return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
	    	   
	
	       }
}
