package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.Customer;
import com.qa.pages.Login;
import com.qa.pages.Manager;

import Base.Base;

public class ManagerTest extends Base {

	
	Login log;
	Manager manager;
	Customer cust;
	
	public ManagerTest (){
		
		super();
	}
	
	
	@BeforeMethod
	
	public void SetUp(){
		
		intilization();
		log=new Login();
		manager=new Manager();
		manager=log.Login1(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	
	public void TearDown(){
		driver.quit();
		
	}
	@Test(priority=1)
	public void ValidateTitle(){
		String title=manager.ValidateManagerPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage","failed");
	}
	
	
	@Test(priority=2)
	
	public void  VerifyCuurentUserName(){
		
		Assert.assertTrue(manager.VerifyUserName());
	}
	
	@Test(priority=3)
	
	public void VerifyContactsLink(){
	 cust=manager.ClickNewCustomer();
		
	}
	
	
}
