package Automation_ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport_Test01 {
	public static ExtentReports extent;
	public static WebDriver driver;
	@Test
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("AutomationExtentResults");
		report.config().setDocumentTitle("results");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("pavan", "TestingResults");
		
		
	}
	@Test(priority = 1)
	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		extent.createTest("Launch Application");
		System.out.println(driver.getCurrentUrl());
		driver.close();
		extent.flush();
	}
	@Test(priority = 2)
	public void launchNegtiveApplication() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		ExtentTest text2=extent.createTest("Launch Application");
		System.out.println(driver.getCurrentUrl());
		driver.close();
		text2.fail("result not match");
		extent.flush();
	}

}
