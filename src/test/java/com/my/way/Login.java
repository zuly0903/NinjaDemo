package com.my.way;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class Login extends BaseTest{

	@Test(priority = 1)
	public void LogInWithValidCrendential() {
		LoginConfig();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("azusaidi0129@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("zulidili0129");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed());
		driver.quit();
	}
	
	@Test(priority = 2)
	public void LoginWithInvalidPasswordValidEmail() {
		SetUp();
		LoginConfig();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("azusaidi0129@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(generateDateTimeSetUp());
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		driver.quit();
		
	}
	
	@Test(priority = 3)
	public void LoginWithValidPasswordInValidEmail() {
		SetUp();
		LoginConfig();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateDateTimeSetUp()+"@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("zulidili0129");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		driver.quit();
		
	}
	
	@Test(priority = 4)
	public void LoginWithInValidPasswordInValidEmail() {
		SetUp();
		LoginConfig();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateDateTimeSetUp()+"6@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(generateDateTimeSetUp());
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		driver.quit();
		
	}
	
	@Test(priority = 5)
	public void LoginWithNoCredentials() {
		SetUp();
		LoginConfig();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		driver.quit();
		
	}
	
	
}
