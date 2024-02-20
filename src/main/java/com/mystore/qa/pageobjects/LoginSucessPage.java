package com.mystore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSucessPage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[@class = 'login']")
	private WebElement signInBtn;
	
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[@title = 'Orders']")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//div[@id= 'center_column']/h1")
	private WebElement loginPageHeading;
	
//	PAge Factory Object 
	public LoginSucessPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	
	public void signInClick() {
		signInBtn.click();
	}
	public void UserEmail() {
		username.sendKeys("lomay21094@tupanda.com");
	}
	public void UserPassword() {
		password.sendKeys("123456");
	}
	public void SubmitBtn() {
		loginBtn.click();
	} 
	
	public String OrderHistory() {
		String odHistory = orderHistory.getText();
		return odHistory;
	}
	
	public String pageHeading() {
		String lnpageHeading = loginPageHeading.getText();
		return lnpageHeading;
	}
}
