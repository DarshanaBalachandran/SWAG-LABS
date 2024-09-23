package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cart {
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void Login()
	{
		driver.get("https://www.saucedemo.com/");
	}
  @Test(priority = 8)
	public void Rightlogin()
	{
		driver.get("https://www.saucedemo.com/");
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
	}
  @Test(priority = 9)
  public void cart()
  
  {
	  WebElement cart = driver.findElement(By.id("shopping_cart_container"));
	  cart.click();
	  
	  WebElement continueshoppingbutton = driver.findElement(By.id("continue-shopping"));
	  continueshoppingbutton.click();
	  
	  WebElement cart1 = driver.findElement(By.id("shopping_cart_container"));
	  cart1.click();
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "The cart page has navigated");

	  WebElement checkout = driver.findElement(By.id("checkout"));
	  checkout.click();
	   
  }
  
  @AfterTest
  public void CLOSE() {
   if (driver != null) {
    driver.quit();
}
}
}
