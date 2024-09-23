package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Productpage {
	WebDriver driver = new ChromeDriver();
	
	
	@BeforeTest
	public void Loginlink()
	{
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "Page title does not match");

	}
	
	
	@Test(priority = 6)
	public void logincredentials()
	{
		driver.get("https://www.saucedemo.com/");
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed or did not redirect to inventory page");


}
	
	@Test(priority =7)
	public void productdetails()
	{
		WebElement product = driver.findElement(By.id("item_4_title_link"));
		product.click();
		
		WebElement productdetails = driver.findElement(By.id("add-to-cart"));
		productdetails.click();

		WebElement removeButton = driver.findElement(By.id("remove"));
		removeButton.click();
		
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
		addToCartButton.click();

		driver.findElement(By.id("back-to-products")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Not redirected back to the products page");

		
		
		
	}
	
	@AfterTest
	  public void CLOSE() {
	   if (driver != null) {
	    driver.quit();
	}
	}
}

