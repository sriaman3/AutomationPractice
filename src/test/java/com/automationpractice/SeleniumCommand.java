package com.automationpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommand {
	
	public static WebDriver driver;
	
	@Test
	void setUP() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("aman@gmail.com");
		Thread.sleep(4000);
		String element = driver.findElement(By.cssSelector("button#SubmitLogin")).getTagName();
		System.out.println(element);
		
		//Assert.assertEquals(element, "Signin");  //Hard Assertion
		Thread.sleep(4000);
		driver.close();
	}
	//getCssValue("font-size");  background-color
}
