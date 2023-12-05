package Automation_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;

public class Extent_ReportsNG extends BaseClass{
	public static ExtentReports extent;
	
	public static ExtentReports getExtentReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("AutomationExtentResults");
		report.config().setDocumentTitle("results");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("pavan", "TestingResults");
		return extent;
		
		
	}
}
