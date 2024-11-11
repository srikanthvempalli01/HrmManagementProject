package com.HrmManagement.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HrmManagement.PageObjectClasses.LoginPage;

public class TC_TestCaseLogin_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("enter username");
		Thread.sleep(5000);
		lp.setPassword(passwd);
		logger.info("enter password");
		Thread.sleep(5000);
		lp.clickLogin();
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true); 
			logger.info("login succesffully");
			lp.clickDropdown();
			lp.clickLogout();
			logger.info("logout successfully");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("login failed");
		}
		
		
	}
}
