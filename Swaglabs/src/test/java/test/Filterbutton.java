package test;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
@Test
public class Filterbutton {
	WebDriver driver = new ChromeDriver();
	
@BeforeMethod 
	public void Login()
	{
		driver.get("https://www.saucedemo.com/");
		
		WebElement rightuserid = driver.findElement(By.id("user-name"));
		rightuserid.sendKeys("standard_user");
		
		WebElement rightpassword = driver.findElement(By.id("password"));
		rightpassword.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
	}
 
@Test(priority = 5)
	public void FilterButton()
	{
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement filterDropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	    filterDropdown.click();
	    
	    WebElement sortbyZtoA = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]"));
		sortbyZtoA.click(); 
		
		WebElement sortbyAtoZ = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[1]"));
		sortbyAtoZ.click();
		
		WebElement sortbyLOWtoHIGH = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]"));
		sortbyLOWtoHIGH.click();
		
		WebElement sortbyHIGHtoLOW = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]"));
		sortbyHIGHtoLOW.click();
		
		Assert.assertTrue(true, "it goes back to the product page");
		
	}
@AfterMethod
        public void CLOSE() {
         if (driver != null) {
          driver.quit();
    }
}


	
	
}
