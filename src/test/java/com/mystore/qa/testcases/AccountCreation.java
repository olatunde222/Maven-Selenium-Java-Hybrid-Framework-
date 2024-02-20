package com.mystore.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mystore.qa.base.BaseClass;
import com.mystore.qa.pageobjects.AccountCreationPage;

public class AccountCreation extends BaseClass{

	public WebDriver driver;
	AccountCreationPage accountCreation;
	
	@Test
	public void AccountRegisteration() throws InterruptedException{
		driver = loadBrowser();
		accountCreation = new AccountCreationPage(driver);
		accountCreation.signIn();
		accountCreation.userName();
		accountCreation.createBtn();
		accountCreation.genderClick();
		accountCreation.firstname();
		accountCreation.lastname();
		accountCreation.password();
		accountCreation.day();
		accountCreation.month();
		accountCreation.year();
//		Thread.sleep(5000);
		accountCreation.agreement();
		accountCreation.regBtn();
		
	}
	
	
}
