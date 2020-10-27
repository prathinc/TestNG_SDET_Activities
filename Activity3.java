package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
 
	WebDriver driver;
	@BeforeClass
	  public void launchBrowser()  {
	  	String driverPath = System.getProperty("user.dir")
					+ File.separator
					+ "drivers"
					+ File.separator
					+ "geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/login-form");
		}

	@Test
  public void login() {
	WebElement username = driver.findElement(By.id("username"));
	WebElement password = driver.findElement(By.id("password"));
	username.sendKeys("admin");
	password.sendKeys("password");
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
	String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	assertEquals(loginMessage, "Welcome Back, admin","login message is displayed");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
