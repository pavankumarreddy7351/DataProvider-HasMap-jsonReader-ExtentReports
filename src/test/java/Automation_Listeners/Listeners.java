package Automation_Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Automation_ExtentReports.Extent_ReportsNG;
import BaseClass.BaseClass;

public class Listeners extends BaseClass implements ITestListener {
	public static ExtentTest test;
	ExtentReports extent = Extent_ReportsNG.getExtentReports();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println(result.getStatus());
		extentTest.set(test);//unique thread Id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Pass");
		System.out.println(result.getStatus());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());
		// explictliy failing
		extentTest.get().fail(result.getThrowable());
		// screen shot
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		System.out.println(result.getStatus());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Pass");
		System.out.println(result.getStatus());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		extentTest.get().log(Status.INFO, "Pass");
		System.out.println(result.getStatus());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		extentTest.get().log(Status.WARNING, "Pass");
		System.out.println(result.getStatus());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(context.getName());

		extent.flush();

	}

}
