package com.Testjava;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mainjava.LoginPage;
import com.Mainjava.TestBase;

public class LoginPageTests extends TestBase{

	LoginPage loginpage;
	
	public LoginPageTests(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initialize();
		loginpage=new LoginPage();
	}
	@Test
	public void loginTest(){
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validatehambuger(){
		//boolean flag=loginpage.validatehambuger();
		//assertTrue(flag);
	}
	
	
}
