package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class Customer extends Base{

	//p[text()="Customer Registered Successfully!!!"]
	//td[text()="Customer ID"]/following-sibling::td
@FindBy(xpath="//p[text()='Customer Registered Successfully!!!']")
	
	WebElement SucessMessage;
	
	@FindBy(xpath="//p[text()='Add New Customer']")
	
	WebElement custNmeLabel;
	
	@FindBy(xpath="//td[text()='Customer ID']/following-sibling::td")
			WebElement custId;
			
	
	
	
	//td[text()="Customer ID"]
	
	

	
	//input[@name="name"]
	
	@FindBy(xpath="//input[@name='name']")
	
	WebElement label_CustName;
	
@FindBy(xpath="//input[@value='f']")
	
	WebElement Gender;
	
@FindBy(xpath="//input[@name='dob']")

WebElement Dob;

@FindBy(xpath="//textarea[@name='addr']")

WebElement Adress;

//input[@name="city"]

@FindBy(xpath="//input[@name='city']")

WebElement City;
//input[@name="state"]

@FindBy(xpath="//input[@name='state']")

WebElement State;


//input[@name="pinno"]
@FindBy(xpath="//input[@name='pinno']")

WebElement pIN;

//input[@name="telephoneno"]

@FindBy(xpath="//input[@name='telephoneno']")

WebElement telephone;

//emailid

@FindBy(xpath="//input[@name='emailid']")

WebElement emailid;

//password
@FindBy(xpath="//input[@name='password']")

WebElement password;

//sub

@FindBy(xpath="//input[@name='sub']")

WebElement Submit;


	public Customer(){
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyLabel(){
		custNmeLabel.isDisplayed();
		return true;
	}
	
	
	public void CreateNewCustomer(String customername, String dob,String adress,String city,String statae,String pin
			,String phhone,String email1,String pass){
		
		label_CustName.sendKeys(customername);
		Gender.click();
		Dob.sendKeys(dob);
		Adress.sendKeys(adress);
		City.sendKeys(city);
		State.sendKeys(statae);
		pIN.sendKeys(pin);
		telephone.sendKeys(phhone);
		emailid.sendKeys(email1);
		password.sendKeys(pass);
		Submit.click();
		
		
	}
	public boolean CustomerSucessfullyRegiseted(){
		return SucessMessage.isDisplayed();
		
	}
	
	public String getCustID(){
		return custId.getText();
		
	}
	
	
}
