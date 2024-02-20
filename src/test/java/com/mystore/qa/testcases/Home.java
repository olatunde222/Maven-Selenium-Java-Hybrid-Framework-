package com.mystore.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mystore.qa.base.BaseClass;


public class Home extends BaseClass{
	public WebDriver driver;

	@Test
	public void loadHome() {
		driver = loadBrowser();
		driver.findElement(By.id("search_query_top")).sendKeys("shirts");
	}
}
