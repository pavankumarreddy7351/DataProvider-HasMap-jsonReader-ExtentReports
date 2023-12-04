package Automation_DataProvider_Using_JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class DataProvider_Using_Json extends BaseClass {
	@Test(dataProvider = "getData")
	public void f(HashMap<String, String> input) throws Exception {
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(input.get("userName"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(input.get("passWord"));
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("userName", prop.getProperty("userName"));
//		map.put("passWord", prop.getProperty("passWord"));
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("userName", prop.getProperty("userName"));
//		map1.put("passWord", prop.getProperty("passWord"));
//		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Automation_DataProvider_Using_JSON\\properties.json");
		
		return new Object[][] { { data.get(0)}, { data.get(1) } };
	}
}
