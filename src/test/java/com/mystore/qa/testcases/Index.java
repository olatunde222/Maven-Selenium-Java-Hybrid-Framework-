package com.mystore.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.qa.base.BaseClass;
import com.mystore.qa.pageobjects.IndexPage;


public class Index extends BaseClass {
	
	public WebDriver driver;
	IndexPage indexPage;
	@Test
	public void verifyLogo() {
		driver = loadBrowser();
		indexPage = new IndexPage(driver);
		Boolean logodisplayed = indexPage.ValidateLogo();
		Assert.assertEquals(true,logodisplayed);
		
	}
	@Test
	public void verifyTitle() {
		driver = loadBrowser();
		indexPage = new IndexPage(driver);
		String titledisplayed = indexPage.VerifyTitle();
		Assert.assertTrue(titledisplayed.equals("My Shop"));
	}
	
	
	
}
