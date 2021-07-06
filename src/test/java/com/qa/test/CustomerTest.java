package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Customer;
import com.qa.pages.Login;
import com.qa.pages.Manager;

import Base.Base;
import Utitity.Uitil;

public class CustomerTest extends Base {

	Login log;
	Manager manager;
	Customer cust;
	
	public CustomerTest (){
		
		super();
	}
	
	
	@BeforeMethod
	
	public void SetUp(){
		
		intilization();
		log=new Login();
		//cust=new Customer();
		manager=log.Login1(prop.getProperty("username"), prop.getProperty("password"));
		cust=manager.ClickNewCustomer();
	}
	
	
	@AfterMethod
	
	public void TearDown(){
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void VerifyLabel(){
		Assert.assertTrue(cust.VerifyLabel());
		
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException{
		Object[][] data=Uitil.getTestData();
		
		return data;
		
	}
	
	@Test(priority=4,dataProvider="getData")
	public void CreateNewContact(String fname,String dob,String adress,String city,String state ,String pin,String phone,String email,String paass){
		
		cust.CreateNewCustomer(fname, dob, adress,city,state,pin ,phone, email, paass);
	Assert.assertTrue(cust.CustomerSucessfullyRegiseted());
	String custId=	cust.getCustID();
	System.out.println(custId);
	}
	
	
	
	
	
}
