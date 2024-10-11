package com.orange.hrm.test;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.orange.hrm.pages.LoginPage;
import com.utility.ExcelUtility;
import com.utility.PropertiesUtility;
public class LoginTest extends BaseTest{
	
	@Test
	public void loginWithValidUserNameAndValidPassword() throws InvalidFormatException, IOException {
		
		LoginPage loginPage = new LoginPage();
		loginPage.loginToApplication("Admin","admin123");
		//loginPage.loginToApplication(ExcelUtility.getTestDate(1,0), ExcelUtility.getTestDate(1,1));
		//loginPage.loginToApplication(PropertiesUtility.getData("username"),PropertiesUtility.getData("password"));
		
	}

}
