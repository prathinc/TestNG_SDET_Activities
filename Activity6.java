package testng;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
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
	@Parameters({"username","password"})
  public void login(String username, String password) {
	WebElement usernameField = driver.findElement(By.id("username"));
	WebElement passwordField = driver.findElement(By.id("password"));
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
	String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	assertEquals(loginMessage, "Welcome Back, admin","login message is displayed");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
