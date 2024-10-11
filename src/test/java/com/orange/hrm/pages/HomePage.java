package com.orange.hrm.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.orange.hrm.test.BaseTest;
import com.report.ExtentReportUtils;

public class HomePage {
	
	@FindBy(xpath = "//span[text()='Admin']")
     WebElement adminlink;
	
	@FindBy(xpath = "//i[contains(@class, 'oxd-userdropdown-icon')]")
	WebElement profilePicture;
	
	@FindBy(xpath ="//a[@class='oxd-userdropdown-link' and text()='Logout']")
	WebElement logoutlink;
	
	public HomePage(){
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	Logger log = LogManager.getLogger(HomePage.class);
	public void clickOnAdminLink() {
		 adminlink.click();
		 log.info("Admin link is clicked.");
	}
	
	public void logoutFromApplication()

	{
		profilePicture.click();
		log.info("profile Picture button is clicked.");
		
		ExtentReportUtils.addStep("Profile picture image is clicked");
		
		logoutlink.click();
		log.info("Logout link is cliked.");
		ExtentReportUtils.addStep("Logout link is clicked");
	}


}
//a[@href='/web/index.php/auth/logout']
//a[@class='oxd-userdropdown-link' and text()='Logout']
