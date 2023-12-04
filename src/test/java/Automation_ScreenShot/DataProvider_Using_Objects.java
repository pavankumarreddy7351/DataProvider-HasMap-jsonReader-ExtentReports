package Automation_ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.core.util.FilePathUtil;

import BaseClass.BaseClass;

public class DataProvider_Using_Objects extends BaseClass{
  @Test(dataProvider = "getData")
  public void f(String string,String string1) throws Exception {
	  System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(string);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(string1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		Thread.sleep(2000);

  }
  public String screenShot(String testCaseName) throws IOException {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	 File source= ts.getScreenshotAs(OutputType.FILE);
	 File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	 FileUtils.copyFile(source, file);
	 return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	 
	 
  }
  @DataProvider
  public Object[][] getData() {
	  return new Object[][] {{prop.getProperty("userName"),prop.getProperty("passWord")},{prop.getProperty("userName1"),prop.getProperty("passWord1")}};
  }
}
