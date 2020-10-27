package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
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
			driver.get("https://www.training-support.net/selenium/target-practice");
		}

  @Test
  public void testCase01() {
	  String actual_title = driver.getTitle();
	  assertEquals(actual_title, "Target Practice", "Title is matching");
	  }
  
  @Test
  public void testCase02() {
	  WebElement blackButton = driver.findElement(By.linkText("Black"));
	  String buttonValue = blackButton.getText();
	  assertEquals(buttonValue, "White", "Value is matching");
	  }
  
  @Test(enabled = false)
  public void testCase03() {
	  //This test will be skipped and not counted
      String subHeading = driver.findElement(By.className("sub")).getText();
      assertTrue(subHeading.contains("Practice"));
	  }
  
  @Test
  public void testCase04() {
	  throw new SkipException("Test case is skipped");
	  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
