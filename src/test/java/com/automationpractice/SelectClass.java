package com.automationpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		SelectClass.verifyToMatchValueFromDropdown();
	}
	
	/*
	 * By using only select class and methods
	 */
	static void verifyToSelectValueFromDropdown() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?id_category=10&controller=category");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement ele =  driver.findElement(By.xpath("//*[@id='selectProductSort']"));
		Select select = new Select(ele);
		
		//select.selectByIndex(1);
		//select.selectByValue("reference:asc");
		//select.selectByVisibleText("Product Name: A to Z");
	}
	
	/*
	 * Verify to match or print the dropdown data on console
	 */
	static void verifyToMatchValueFromDropdown() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?id_category=10&controller=category");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement ele =  driver.findElement(By.xpath("//*[@id='selectProductSort']"));
		
		Select select = new Select(ele);
		
		List<WebElement> options = select.getOptions();  //Interview Question
		
		for(WebElement element : options) {
			System.out.println(element.getText());
		}
		
		//System.out.println(options.get(1).getText());
		
	}

}
