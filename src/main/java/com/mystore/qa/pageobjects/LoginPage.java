/**
 * 
 */
package com.mystore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.BaseClass;

/**
 * 
 */
public class LoginPage extends BaseClass {

	WebDriver driver;
	
	@FindBy(xpath = "//a[@class = 'login']")
	private WebElement signInBtn;
	
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginBtn;
	
	
//	Page Factory Object
	public LoginPage(WebDriver driver) {
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
	
}
