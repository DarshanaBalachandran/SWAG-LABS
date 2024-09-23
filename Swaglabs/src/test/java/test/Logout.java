package test;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Logout {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	@BeforeTest
	public void login()
	{
		driver.get("https://www.saucedemo.com/");

	}
	
	
	@Test(priority = 11)
	public void logout()
	{
		driver.get("https://www.saucedemo.com/");
		
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();


		WebElement menu2 = driver.findElement(By.id("react-burger-menu-btn"));
		menu2.click();
		
		WebElement Logout= wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        Logout.click();
		Assert.assertTrue(true, "unsuccessful");
		
		
	}
	@AfterTest
	  public void CLOSE() {
	   if (driver != null) {
	    driver.quit();
	}
	}
	

}
