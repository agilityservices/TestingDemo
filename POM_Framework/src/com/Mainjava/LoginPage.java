package com.Mainjava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

	//Contains all locators of loginpage. this is POM
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//*[@type='submit']")
	WebElement btnsubmit;
	@FindBy(xpath= "//*[@aria-label='menu']")
	WebElement hamburgerlogo;
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String un,String pwd){
		email.sendKeys(un);
		password.sendKeys(pwd);
		btnsubmit.click();
	}
	public boolean validatehambuger(){
		return hamburgerlogo.isDisplayed();
	}


	
	
}
