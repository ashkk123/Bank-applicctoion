package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.pages.Login;
import com.qa.pages.Manager;

import Base.Base;

public class LoginPageTest extends Base{

	Login log;
	Manager manager;
	
	public LoginPageTest(){
		
		super();
	}
	
	
	Logger log1=Logger.getLogger(LoginPageTest.class);
	
	@BeforeMethod
	
	public void SetUp(){
		
		intilization();
		log=new Login();
		
	}
	
	
	@AfterMethod
	
	public void TearDown(){
		log1.info("teardowwncalling");
		driver.quit();
		
		
	}
	
	
	@Test(priority=2)
	public void VerifyLoginPageTitle(){
		String title=log.validatetitle();
		log1.info("titlerecieved");
		Assert.assertEquals(title, "Guru99 Bank Home Page");
		log1.info(prop);
	}
	
	@Test(priority=1)
	public void VerifyUserLogin(){
		
		manager=log.Login1(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
}
