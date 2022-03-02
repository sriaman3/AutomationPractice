package com.automationpractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommands {
	
	public  WebDriver driver;
	
	  @BeforeTest 
	  public void setUP() { 
		  WebDriverManager.chromedriver().setup();
//		  driver = new ChromeDriver();
	  }
	 
	
	@Test
	public void login() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	
	@Test
	public void logins() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
