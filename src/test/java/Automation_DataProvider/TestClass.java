package Automation_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Automation_Listeners.Retry;
import BaseClass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass extends BaseClass{
	@Test(retryAnalyzer=Retry.class)
	public void tesingListener() {

		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyaucademy");
		driver.findElement(By.xpath("//input[@id='passwor']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
	}
	@Test
	public void tesingListener2() {

		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyauuuuuuuucademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learningqqqqqqqqq");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
	}

}
