package com.mystore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.qa.base.BaseClass;


public class IndexPage extends BaseClass{

	WebDriver driver;
	@FindBy(xpath = "//img[@class = 'logo img-responsive']")
	private WebElement StoreLogo;
	
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	public Boolean ValidateLogo() {
		return StoreLogo.isDisplayed();
	}
	
	public String VerifyTitle() {
		String PageTitle = driver.getTitle();
		return PageTitle;
	}
}
