package Automation_DataProvider;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class DataProvider_Using_HashMap extends BaseClass {
	@Test(dataProvider = "getData")
	public void f(HashMap<String, String> input) throws Exception {
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(input.get("userName"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(input.get("passWord"));
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userName", prop.getProperty("userName"));
		map.put("passWord", prop.getProperty("passWord"));

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("userName", prop.getProperty("userName"));
		map1.put("passWord", prop.getProperty("passWord"));
		return new Object[][] { { map }, { map1 } };
	}
}
