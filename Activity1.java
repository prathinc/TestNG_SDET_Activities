package testng;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class Activity1 {
	

    WebDriver driver;
    
    @BeforeMethod
	public void launchBrowser()  {
    	String driverPath = System.getProperty("user.dir")
				+ File.separator
				+ "drivers"
				+ File.separator
				+ "chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.training-support.net");
	}

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
            //Assertion for page title
        assertEquals("Training Support", title);
                    
        //Find the clickable link on the page and click it
        driver.findElement(By.id("about-link")).click();
                    
        //Print title of new page
        System.out.println("New page title is: " + driver.getTitle());
        
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}