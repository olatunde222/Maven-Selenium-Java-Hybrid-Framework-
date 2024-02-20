package com.mystore.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.Utils.Utilities;
import com.mystore.qa.base.BaseClass;

public class AccountCreationPage extends BaseClass{

	
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[@class = 'login']")
	private WebElement signInBtn;
	
	@FindBy(id = "email_create")
	private WebElement UserEmail;
	
	@FindBy (id = "SubmitCreate")
	private WebElement CreateUserBtn; 
	
	@FindBy (id = "id_gender1")
	private WebElement SelectGender;
	
	@FindBy (id = "customer_firstname")
	private WebElement firstName;
	
	@FindBy (id = "customer_lastname")
	private WebElement lastName;
	
	@FindBy (id = "passwd")
	private WebElement passWord;
	
	@FindBy (id = "days")
	private WebElement daySelection;
	
	@FindBy (id = "months")
	private WebElement monthSelection;
	
	@FindBy (id = "years")
	private WebElement yearSelection;
	
	@FindBy (id = "newsletter")
	private WebElement newsLetterAgreement;
	
	@FindBy (id = "submitAccount")
	private WebElement resgisterBtn;
	
//	Object Factory
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	public void signIn() {
		signInBtn.click();
	}
	public void userName(){
		UserEmail.clear();
		UserEmail.sendKeys(Utilities.timeStamp()+"@gmail.com");
	}
	public void createBtn() {
		CreateUserBtn.click();
	}
	public void genderClick() {
		SelectGender.click();
		
	}
	public void firstname() {
		firstName.sendKeys("Automation");
	}
	
	public void lastname() {
		lastName.sendKeys("Tester");
	}
	public void password() {
		passWord.sendKeys("1234567");
	}
	public void day() {
		Select dayDrop = new Select(daySelection);
		dayDrop.selectByIndex(20);
	}
	public void month() {
		Select monthDrop = new Select (monthSelection); 
		monthDrop.selectByVisibleText("February "); 
	}
	public void year() {
		Select yearDrop = new Select(yearSelection);
		yearDrop.selectByValue("2018");
	}
	public void agreement() {
		newsLetterAgreement.click();
	}
	public void regBtn() {
		resgisterBtn.click();
	}
}
