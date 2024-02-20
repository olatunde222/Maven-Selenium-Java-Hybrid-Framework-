package com.mystore.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports ExtentReportGenerator() {
		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("My Store Test Automation Report");
		sparkReporter.config().setDocumentTitle("MS Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		
		extentReports.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		try {
			FileInputStream exReportFis = new FileInputStream(propFile);
			configProp.load(exReportFis);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		
		extentReports.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReports.setSystemInfo("Email", configProp.getProperty("username"));
		extentReports.setSystemInfo("password", configProp.getProperty("password"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReports;
		
	}
}
