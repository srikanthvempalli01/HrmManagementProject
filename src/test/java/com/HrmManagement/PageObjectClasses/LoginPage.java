package com.HrmManagement.PageObjectClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage 
{
	//constructor
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//locators
	@FindBy(xpath="//input[@placeholder='Username']") 
	WebElement uid;
	@FindBy(xpath="//input[@placeholder='Password']") 
	WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	WebElement dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	WebElement logout;
	//Methods
	public void setUsername(String username)
	{
		uid.sendKeys(username);
	}
	public void setPassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	public void clickLogin()
	{
		login.click();
	}
	public void clickDropdown()
	{
		dropdown.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	
}
