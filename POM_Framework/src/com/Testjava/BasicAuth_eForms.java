package com.Testjava;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicAuth_eForms {
	WebDriver driver;
	
	@Test
	
	public void loginToeForms() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://eforms.agility.com/");
		
		//Runtime.getRuntime().exec("C:\\Users\\gmaddirala\\Downloads\\AutoIt_Scripts\\eForms_Login.exe");
		
	}
}
