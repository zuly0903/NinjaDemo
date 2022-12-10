package ninjademo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjademo.base.TestBase;
import com.qa.ninja.utilities.*;

public class Login_test extends TestBase{

	public Login_test() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}



	public static WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		driver = initializeBrowser("chrome");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	}
	
	@Test(priority = 1)
	public void LogInWithValidCrendential() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("#input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void LoginWithInvalidPasswordValidEmail() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("#input-password")).sendKeys(Utilities.generateDateTimeSetUp());
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		
		
	}
	
	@Test(priority = 3)
	public void LoginWithValidPasswordInValidEmail() {

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateDateTimeSetUp()+"@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		
		
	}
	
	@Test(priority = 4)
	public void LoginWithInValidPasswordInValidEmail() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateDateTimeSetUp()+"6@gmail.com");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(Utilities.generateDateTimeSetUp());
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		
	}
	
	@Test(priority = 5)
	public void LoginWithNoCredentials() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String ActualwarningMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		String ExpectedwarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(ActualwarningMessage, ExpectedwarningMessage);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
}
}
