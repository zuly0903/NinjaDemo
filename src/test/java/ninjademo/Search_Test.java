package ninjademo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjademo.base.TestBase;

public class Search_Test extends TestBase {

	public Search_Test() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = initializeBrowser("Edge");
		
	}
	
	@Test
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("samsung");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Samsung SyncMaster 941BW")).isDisplayed());
	}
	
	@Test
	public void verifySearchWithInValidProduct() {
		driver.findElement(By.name("search")).sendKeys("dell");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualnoProductMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		Assert.assertEquals(actualnoProductMessage, "There is no product that matches the search criteria.");
	}
	
	@Test
	public void verifySearchWithoutProduct() {
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualInvalidSearchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		Assert.assertEquals(actualInvalidSearchMessage, "There is no product that matches the search criteria.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
