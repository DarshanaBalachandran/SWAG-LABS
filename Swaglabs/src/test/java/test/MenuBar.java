package test;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class MenuBar {
	
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@Test(priority = 3)
	public void Swaglabs()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	
	
	@Test(priority = 4)
	public void login()
	{
		driver.get("https://www.saucedemo.com/");
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
        menuButton.click();
        
        Assert.assertTrue(true,"The menu bar has clicked");
        
		WebElement Wrongbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-cross-btn")));
        Wrongbutton.click();
        
        Assert.assertTrue(true,"The menu bar has closed");
	}
	
	@AfterTest
	  public void CLOSE() {
	   if (driver != null) {
	    driver.quit();
	}
	}
	
	}

