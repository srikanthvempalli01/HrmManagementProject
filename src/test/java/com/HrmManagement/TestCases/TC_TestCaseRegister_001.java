package com.HrmManagement.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HrmManagement.PageObjectClasses.RegisterPage;

public class TC_TestCaseRegister_001  extends BaseClass
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
		String username=generateRandomUsername(6);
		rp.setUsername(username);
		String password=generateRandomPassword(6);
		rp.setPassword(password);
		String cnPassword=generateConfirmPassword(password);
		rp.setConfirmPassword(cnPassword);
		Thread.sleep(5000);
		rp.registerButton();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("ParaBank | Customer Created"))
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
	public String generateRandomUsername(int length) 
	{
        return RandomStringUtils.randomAlphanumeric(length);
    }
    public String generateRandomPassword(int length) 
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        return RandomStringUtils.random(length, characters);
    }
    public String generateConfirmPassword(String password)
    {
        return password;
    }
}
