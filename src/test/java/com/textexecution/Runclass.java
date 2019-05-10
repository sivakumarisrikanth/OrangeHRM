package com.textexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.generic.Webcommonmethods;
import com.selweb.Webclass;

public class Runclass extends Webcommonmethods {
	public static WebDriver driver;
	public static Webclass appcls;
	@Test(priority=0)
	public  void mainexecution() {
		looger=report.createTest("loginhrm");
		
	driver= Webcommonmethods.getbrowser("Chrome");
		//Webcommonmethods.closebrowser();
		appcls=PageFactory.initElements(driver, Webclass.class);
		appcls.login();
	}
	@Test(priority=1)
	public void leave() {
		looger=report.createTest("apply leave");
		appcls.applyleave();
		looger.pass("successfully excecuted");
	

}
}
