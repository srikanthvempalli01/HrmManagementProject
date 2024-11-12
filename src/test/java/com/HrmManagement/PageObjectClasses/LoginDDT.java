package com.HrmManagement.PageObjectClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginDDT 
{
	WebDriver ldriver;
	public LoginDDT(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Log In']") 
	WebElement login;
	@FindBy(xpath="//a[normalize-space()='Log Out']") 
	WebElement logout;

	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	public void setPassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	public void clickLogin()
	{
		login.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
}
