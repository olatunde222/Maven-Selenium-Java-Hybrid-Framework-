package com.mystore.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.Utils.Utilities;



public class BaseClass {

	WebDriver driver;
	public Properties prop;
	@BeforeMethod

//	Properties Configuration
	public void loadConfiguration() {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	
//	Browser Set-up
	public WebDriver loadBrowser() {
	String browserName = prop.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}


	public void click(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		
	}


	public boolean findElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}
}
