package com.myStoreProject.qa.listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.Utils.ExtentReporter;

public class myStoreListners implements ITestListener{

//	Gobal Varaibles
	ExtentReports extentReports;
	ExtentTest extentTest;
	String testName;
	
	
	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReporter.ExtentReportGenerator();
//		System.out.println("Started Executing");
	}
	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReports.createTest(testName);
		extentTest.log(Status.INFO, testName + " Started Executing");
//		System.out.println(testName + " Started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		String testName = result.getName();
		extentTest.log(Status.PASS, testName + " Executed Successfully");
//		System.out.println(testName + " Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String testName = result.getName();
		
//		Code for taking screenshot
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		// Creating a path and nwe folder for the screenshots 
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotDestinationPath = System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		try{
			FileHandler.copy(srcScreenshot, new File(ScreenshotDestinationPath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		// Embedding the screenshot into extent-report
		extentTest.addScreenCaptureFromPath(ScreenshotDestinationPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+" got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
				
		// Code for automatically opening the extent report after test completion
		String extentReportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html";
		File extentReprt = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(extentReprt.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
