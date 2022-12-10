package com.my.way;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Account_Registration extends BaseTest {
	
	public static WebDriverWait wait;

	@Test
	public void Create_Account() {
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Register')]")))).click();
		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Zuly");
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Saidi");
		driver.findElement(By.cssSelector("#input-email")).sendKeys("azusaidi0129@gmail.com");
		driver.findElement(By.cssSelector("#input-telephone")).sendKeys("2405795604");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("zulidili0129");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("zulidili0129");
		driver.findElement(By.xpath("//label[@class='radio-inline'][2]/child::input")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
		String sucessfullMessage = driver.findElement(By.xpath("//div[@id='content']//child::h1")).getText();
		Assert.assertEquals(sucessfullMessage, "Your Account Has Been Created!");
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}
}
