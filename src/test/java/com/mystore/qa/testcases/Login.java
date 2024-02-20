package com.mystore.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mystore.qa.base.BaseClass;
import com.mystore.qa.pageobjects.LoginPage;


public class Login extends BaseClass{

	public WebDriver driver;
	LoginPage loginPage;
	
	
	@Test
	public void userLogin() throws InterruptedException {
		driver = loadBrowser();
		loginPage = new LoginPage(driver);
		loginPage.signInClick();
		loginPage.UserEmail();
		loginPage.UserPassword();
		Thread.sleep(5000);
		loginPage.SubmitBtn();
		
	}
	
	
}
