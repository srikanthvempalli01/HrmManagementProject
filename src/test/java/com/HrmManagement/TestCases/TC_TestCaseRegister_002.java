package com.HrmManagement.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HrmManagement.PageObjectClasses.RegisterPage;

public class TC_TestCaseRegister_002  extends BaseClass
{
	@Test
	public void registerTest() throws InterruptedException
	{
		driver.get(baseURL1);
		logger.info("url is opened");
		RegisterPage rp=new RegisterPage(driver);
		rp.registerClick();
		rp.setFirstName("SrikanthReddy");
		rp.setLastName("Vempalli");
		rp.setAddress("1/54-A,Illuru Village");
		rp.setAddressCity("Proddatur");
		rp.setAddressState("AndhraPradesh");
		rp.setAddressZipCode("516310");
		rp.setCustomerPhoneNumber("6300807018");
		rp.ssnNumber("123-45-6789");
		rp.setUsername("Srikanth9678@");
		rp.setPassword("Sri9678@");
		rp.setConfirmPassword("Sri9678@");
		Thread.sleep(5000);
		rp.registerButton();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("ParaBank | Register for Free Online Account Access"))
		{
			Assert.assertTrue(true);
			logger.info("Registered Succesffully");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Registered Failed");
		}
		
	}
}
