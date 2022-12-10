package ninjademo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjademo.base.TestBase;
import com.qa.ninja.utilities.*;

public class Regisetr_Test extends TestBase{
	
	public Regisetr_Test() throws Exception {
		super();
	}
	
	
	public static WebDriver driver;
	
	
	@BeforeMethod
	public void SetUp() {
		driver = initializeBrowser("firefox");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	}
	
	@Test
	public void verifyRegisterationWithMyMandatoryFields() {
		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("azull");
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("saidiy");
		driver.findElement(By.cssSelector("#input-email")).sendKeys(Utilities.generateDateTimeSetUp());
		driver.findElement(By.cssSelector("#input-telephone")).sendKeys("2375486785");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("zulidili0129//");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("zulidili0129//");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
		String sucessfullMessage = driver.findElement(By.xpath("//div[@id='content']//child::h1")).getText();
		Assert.assertEquals(sucessfullMessage, "Your Account Has Been Created!");
		//driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}
	
	@Test
	public void verifyRegisterationWithAllFields() {
		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("azuq");
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("saidik");
		driver.findElement(By.cssSelector("#input-email")).sendKeys(Utilities.generateDateTimeSetUp());
		driver.findElement(By.cssSelector("#input-telephone")).sendKeys("2375486789");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("zulidili0129/");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("zulidili0129/");
		driver.findElement(By.xpath("//label[@class='radio-inline'][1]/child::input")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
		String sucessfullMessage = driver.findElement(By.xpath("//div[@id='content']//child::h1")).getText();
		Assert.assertEquals(sucessfullMessage, "Your Account Has Been Created!");
		//driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}
	
	@Test
	public void verifyRegisterationWithNoField(){
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
		
		String actualPrivacyWarning = driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]")).getText();
		Assert.assertTrue(actualPrivacyWarning.contains("Warning: You must agree to the Privacy Policy!"), "Priavcy Warning is not displayed !");
		
		String actualFirstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"), "First Name Warning is not displayed");
		
		String actualLastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(actualLastNameWarning.contains("Last Name must be between 1 and 32 characters!"), "Last Name Warning is not displayed");
		
		String actualEmailWarning = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertTrue(actualEmailWarning.contains("E-Mail Address does not appear to be valid!"), "Email Warning is not displayed");
		
		String actualTelephoneWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertTrue(actualTelephoneWarning.contains("Telephone must be between 3 and 32 characters!"), "Telephone Warning is not displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
