package com.generic;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Webcommonmethods {;

	public static ExtentReports report ;
	public static ExtentTest looger;
	public static WebDriver driver;
	
	public static WebDriver getbrowser(String Browser) {
		if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\sivakumari\\Trainingproject\\Browserdrivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.get("http://www.testingmasters.com/hrm/");
			System.out.println("chrome is launched");
		}
		else if(Browser.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver","E:\\sivakumari\\Trainingproject\\Browserdrivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.get("http://www.testingmasters.com/hrm/");
			System.out.println("firefox is launched");	
		
		
		}
		else if(Browser.equals("internetexplorer")) {
			System.setProperty("webdriver.ie.driver","E:\\sivakumari\\Trainingproject\\Browserdrivers\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			 driver.get("http://www.testingmasters.com/hrm/");
			System.out.println("InternetExplorer is launched");
		
	}
		return driver;
		

}
	public static void closebrowser() {
		driver.close();
		System.out.println("close the window");
	}
	public static String getscreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String screenshotpath= "E:\\sivakumari\\Trainingproject\\screenshots\\screens\\"+ gettimestamp()+".png";
		File source=ts.getScreenshotAs(OutputType.FILE);
		try{
		FileHandler.copy(source,new File(screenshotpath));
		}catch(IOException e) {
			System.out.println("unable to take screenshot "+e.getMessage());
		}
		return screenshotpath;
	}
		
		public static String gettimestamp() {
			DateFormat datevalue=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentdateformat=new Date();
			return datevalue.format(currentdateformat);
		}
		@BeforeSuite
		public static void extentsreportsample() {
			Reporter.log("test is started",true);
			ExtentHtmlReporter extent=new ExtentHtmlReporter("E:\\sivakumari\\Trainingproject\\Reports\\rep"+gettimestamp()+".html");
			report=new ExtentReports();
			report.attachReporter(extent);
			Reporter.log("all methods executed", true);
  
		}
		@AfterMethod
		public static void capturescreenshot(ITestResult result)   {
			Reporter.log("attaching screens to report",true);
			if(result.getStatus()==ITestResult.SUCCESS) 
			{
				try {
					looger.pass("test is success", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build());
				} catch (IOException e) {
					System.out.println("screen is not attaching"+e.getMessage());
				}
			}
			else if(result.getStatus()==ITestResult.FAILURE) 
			{
				try {
					looger.fail("test is failure", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build());
				} catch (IOException e) {
					System.out.println("screen is not attaching"+e.getMessage());
				}
			}
			report.flush();
			Reporter.log("execution is done ");
			
		}
		}
		
	

