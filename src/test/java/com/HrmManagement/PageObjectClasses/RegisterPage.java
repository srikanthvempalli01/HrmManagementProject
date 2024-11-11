package com.HrmManagement.PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
   WebDriver ldriver;
   public RegisterPage(WebDriver rdriver)
   {
	   ldriver=rdriver;
	   PageFactory.initElements(rdriver,this);
   }
   
   @FindBy(xpath="//a[normalize-space()='Register']") 
   WebElement register;
   @FindBy(xpath="//input[@id='customer.firstName']")   
   WebElement firstName;
   @FindBy(xpath="//input[@id='customer.lastName']") 
   WebElement lastName;
   @FindBy(xpath="//input[@id='customer.address.street']") 
   WebElement address;
   @FindBy(xpath="//input[@id='customer.address.city']") 
   WebElement address_city;
   @FindBy(xpath="//input[@id='customer.address.state']")  
   WebElement address_state;
   @FindBy(xpath="//input[@id='customer.address.zipCode']")  
   WebElement address_zipCode;
   @FindBy(xpath="//input[@id='customer.phoneNumber']") 
   WebElement customer_phoneNumber;
   @FindBy(xpath="//input[@id='customer.ssn']") 
   WebElement ssn;
   @FindBy(xpath="//input[@id='customer.username']")  
   WebElement username;
   @FindBy(xpath="//input[@id='customer.password']")  
   WebElement password;
   @FindBy(xpath="//input[@id='repeatedPassword']")  
   WebElement confirmPassword;
   @FindBy(xpath="//input[@value='Register']") 
   WebElement register_button;
   
   public void registerClick()
   {
	   register.click();
   }
   public void setFirstName(String fName)
   {
	   firstName.sendKeys(fName);
   }
   public void setLastName(String lName)
   {
	   lastName.sendKeys(lName);
   }
   public void setAddress(String addrss)
   {
	   address.sendKeys(addrss);
   }
   public void setAddressCity(String addrssCity)
   {
	   address_city.sendKeys(addrssCity);
   }
   public void setAddressState(String addrssState)
   {
	   address_state.sendKeys(addrssState);
   }
   public void setAddressZipCode(String addrssZipCode)
   {
	   address_zipCode.sendKeys(addrssZipCode);
   }
   public void setCustomerPhoneNumber(String phoneNumber)
   {
	   customer_phoneNumber.sendKeys(phoneNumber);
   }
   public void ssnNumber(String ssnNumber)
   {
	   ssn.sendKeys(ssnNumber);
   }
   public void setUsername(String user)
   {
	   username.sendKeys(user);
   }
   public void setPassword(String passwd)
   {
	   password.sendKeys(passwd);
   }
   public void setConfirmPassword(String cnPasswd)
   {
	   confirmPassword.sendKeys(cnPasswd);
   }
   public void registerButton()
   {
	   register_button.click();
   }
   
}
