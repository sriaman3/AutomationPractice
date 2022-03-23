package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomDataProvider {

	public WebDriver driver;
	
	@Test(dataProvider="TestingData", dataProviderClass = DataProviderClass.class)
	public void testData(String firstName, String lastName) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}


}
