package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Login extends Base {

	@FindBy(xpath="//input[@name='uid']")
	WebElement username2;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_login;
	@FindBy(name="btnLogin")
	WebElement btn;
	
	
	
	public Login(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validatetitle (){
		
	return	driver.getTitle();
		
	}
	
	public Manager Login1(String username1,String password1){
		username2.sendKeys(username1);
		password_login.sendKeys(password1);
		btn.click();
		return  new Manager();
	}
	
	
	
}
