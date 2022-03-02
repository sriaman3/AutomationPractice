package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {
	
	public static WebDriver driver; //declartion of Webdriver
	
	public static void main(String[] args) throws InterruptedException {
		RightClick.rightClick();
	}
	
	static void rightClick() throws InterruptedException {
		WebDriverManager.chromedriver().setup();  // set up of browser
		driver = new ChromeDriver(); // open the chrome browser
		
		driver.get("https://demoqa.com/automation-practice-form"); // open the URL
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Name']"));
		Actions act= new Actions(driver); 
		Thread.sleep(3000);
		act.contextClick(ele).perform();  //Right click
	}
}
