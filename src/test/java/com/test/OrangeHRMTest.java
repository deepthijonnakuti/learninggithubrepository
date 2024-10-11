package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest {

	RemoteWebDriver driver;
	 @Test(priority = 1)
	
	    public void login() throws MalformedURLException {
	        // Open Chrome
	       // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	       
	        ChromeOptions browserOptions = new ChromeOptions();
	        browserOptions.setPlatformName("Windows 11");
	        browserOptions.setBrowserVersion("latest");
	        Map<String, Object> sauceOptions = new HashMap();
	        sauceOptions.put("username", "oauth-deepthi.jonnakuti-aef61");
	        sauceOptions.put("accessKey", "3f7a9c15-2566-40f2-8ef4-99527edbae7b");
	        sauceOptions.put("build", "Test Automation");
	        sauceOptions.put("name", "Sanity test");
	        browserOptions.setCapability("sauce:options", sauceOptions);
	    	
	     // start the session
	        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	         driver = new RemoteWebDriver(url, browserOptions);

	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Open login page
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        // Enter username
	        driver.findElement(By.name("username")).sendKeys("Admin");

	        // Enter password
	        driver.findElement(By.name("password")).sendKeys("admin123");

	        // Click on Login button
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        loginButton.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    }
	 @Test(priority = 2)
	public void testAdmin() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isDisplayed = driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")).isDisplayed();		
	   Assert.assertTrue(isDisplayed);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	 @Test(priority = 3)
	public void logout()  {

		 WebElement dropdownIcon = driver.findElement(By.xpath("//i[contains(@class, 'oxd-userdropdown-icon')]"));
       dropdownIcon.click();
       WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
       logoutButton.click();

	}
}


