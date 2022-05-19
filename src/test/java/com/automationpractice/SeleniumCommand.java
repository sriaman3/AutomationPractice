package com.automationpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		System.out.println(driver.getCurrentUrl());


		WebElement element  =  driver.findElement(By.id("email"));
		System.out.println(element.getTagName());
		element.sendKeys("aman@gmail.com");

		Thread.sleep(4000);
		Dimension text = driver.findElement(By.cssSelector("button#SubmitLogin")).getSize();
		System.out.println(text.height); 
		System.out.println(text.width); 
		
		//Assert.assertEquals(element, "Signin"); //Hard
		Thread.sleep(4000);
		driver.close();

	}
	//getCssValue("font-size");  background-color
}
