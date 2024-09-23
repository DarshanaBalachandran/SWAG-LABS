package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Checkoutpage {
	WebDriver driver = new ChromeDriver();
	
	
	@Test(priority = 10)
	public void Login()
	{	
		driver.get("https://www.saucedemo.com/");
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		WebElement cart = driver.findElement(By.id("shopping_cart_container"));
		cart.click();
	}
	
	
	
	@Test(dependsOnMethods = {"Login"})
	public void checkout()
	{
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
		WebElement firstname = driver.findElement(By.id("first-name"));
		firstname.sendKeys("ABC");
		
		WebElement Lastname = driver.findElement(By.id("last-name"));
		Lastname.sendKeys("EFG");
		
		WebElement postalcode = driver.findElement(By.id("postal-code"));
		postalcode.sendKeys("109876");
		
		WebElement continuebutton = driver.findElement(By.id("continue"));
		continuebutton.click();
		
		WebElement finish = driver.findElement(By.id("finish"));
		finish.click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"), "The checkout page has navigated");

		
		WebElement Backtohome = driver.findElement(By.id("back-to-products"));
		Backtohome.click();
	}
	
	@AfterTest
	  public void CLOSE() {
	   if (driver != null) {
	    driver.quit();
	}
	}
}
