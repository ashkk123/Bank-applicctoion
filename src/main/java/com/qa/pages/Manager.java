package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Manager extends Base {

	//td[text()="Manger Id : mngr338473"]
	
	@FindBy(xpath="//td[text()='Manger Id : mngr338473']")
	
	WebElement mangertext;
	@FindBy(xpath="//td//marquee[text()='Welcome To Manager's Page of Guru99 Bank']")
	WebElement welcometext;
	
	
	@FindBy(xpath="//a[text()='Manager']")
	WebElement Manager_link;
	
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement Cust_link;
	
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement Edit_Cust_link;
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement Delete_Cust_link;
	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement New_Account_link;
	
	
	
	@FindBy(xpath="//a[text()='Edit Account']")
	WebElement New_Account_edit_link;
	
	@FindBy(xpath="//a[text()='Delete Account']")
	WebElement New_Account_deletS_link;
	
	public Manager(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public Customer ClickNewCustomer(){
		Cust_link.click();
		return new Customer();
		
	}
	
	public String ValidateManagerPageTitle(){
		
		return driver.getTitle();
	}
	
	public EditCustomer ClickEditCustomer(){
		
		Edit_Cust_link.click();
		
		return new EditCustomer();
	}
	
	
public DeleteCutomer ClickDeleteCustomer(){
		
	Delete_Cust_link.click();
		
		return new DeleteCutomer();
	}

public NewAccount ClickNewAcconut(){
	
	New_Account_link.click();
	
	return new NewAccount ();
}
	
	public boolean VerifyUserName(){
		mangertext.isDisplayed();
		welcometext.isDisplayed();
		return true;
	}


}


