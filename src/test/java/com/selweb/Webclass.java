package com.selweb;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.generic.Webcommonmethods;

public class Webclass {
	Exceldatareader testdata=new Exceldatareader();
	
	//loginobjects
	@FindBy(id="txtUsername")WebElement Username;
	@FindBy(id="txtPassword")WebElement Password;
	@FindBy(name="Submit")WebElement loginbutton;
	
	//Applyleave objects
	
	@FindBy(id="menu_leave_viewLeaveModule")WebElement leavetab;
	@FindBy(id="menu_leave_applyLeave")WebElement applytab;
	@FindBy(xpath="//select[@id='applyleave_txtLeaveType']")WebElement leavetype;
	@FindBy(xpath="//select[@id='applyleave_txtLeaveType']/option [2]")WebElement selectleavetype;
	public void login() {
		String username=testdata.getstringdata("Sheet1",1,1);
		String password=testdata.getstringdata("Sheet1",1,2);
		Username.sendKeys(username);
		Password.sendKeys(password);
		loginbutton.click();
		//Webcommonmethods.getscreenshot();
	}
	public void applyleave() {
		leavetab.click();
		applytab.click();
		leavetype.click();
		selectleavetype.click();
		//Webcommonmethods.getscreenshot();
	}

}
