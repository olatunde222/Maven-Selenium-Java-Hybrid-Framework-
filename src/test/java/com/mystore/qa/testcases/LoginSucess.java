package com.mystore.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.qa.base.BaseClass;
import com.mystore.qa.pageobjects.LoginSucessPage;

public class LoginSucess extends BaseClass{

	public WebDriver driver;
	LoginSucessPage loginSuccessPage;

	@Test
	public void loginSucess() throws InterruptedException {
		driver = loadBrowser();
	
		
		loginSuccessPage = new LoginSucessPage(driver);
		loginSuccessPage.signInClick();
		loginSuccessPage.UserEmail();
		Thread.sleep(5000);
		loginSuccessPage.UserPassword();
		Thread.sleep(5000);
		loginSuccessPage.SubmitBtn();
		String lhDisplay = loginSuccessPage.OrderHistory();
		String phDispaly = loginSuccessPage.pageHeading();
		
		try {
			Assert.assertTrue(lhDisplay.contains("Order history and details"));
			Assert.assertEquals(phDispaly, "My account");
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		
	}
}
