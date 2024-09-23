package test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;



public class Loginpage {
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void Login()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
    @Test
	//checking the location of the logo
	public void logo()
	{
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
	}
	
	//checking with the wrong credentials
	@Test(priority = 1)
	public void wronglogin()
	{
		
		WebElement wronguserid = driver.findElement(By.id("user-name"));
		wronguserid.sendKeys("ABC"); 
		wronguserid.clear();
		
		WebElement wrongpassword = driver.findElement(By.id("password"));
		wrongpassword.sendKeys("123");
		wrongpassword.clear();
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
	}
	@Test(priority = 2)
	//checking with the right credentials
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
	
	@AfterTest
	  public void CLOSE() {
	   if (driver != null) {
	    driver.quit();
	}
	}
}
