package com.my.way;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void LoginConfig() {
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	}
	
	public String generateDateTimeSetUp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");  //To generate a value for negative testing for password and email
	}
	
	
	@AfterTest
		public void tearDown() {
			//driver.quit();
		
	}
}
