package Automation_DataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
  @DataProvider
  public Object[][] getData() {
	  return new Object[][] {{prop.getProperty("userName"),prop.getProperty("passWord")},{prop.getProperty("userName1"),prop.getProperty("passWord1")}};
  }
}
