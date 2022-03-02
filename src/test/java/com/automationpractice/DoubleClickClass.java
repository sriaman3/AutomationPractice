package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickClass {
	
	public static WebDriver driver; //declare the variable
	
	public static void main(String[] args) throws InterruptedException {
		DoubleClickClass.doubleClick();
	}
	
	static void doubleClick() throws InterruptedException {
		WebDriverManager.chromedriver().setup(); //chrome driver set up
		driver = new ChromeDriver();  // open the browser
		
		driver.get("https://demoqa.com/automation-practice-form");  //open the URL
		driver.manage().window().maximize(); //maximize the window
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Name']")); // will identify the web element
		//ele.click();
		Actions act= new Actions(driver); //instantiate the Actions class
		Thread.sleep(3000);
		act.doubleClick(ele).perform(); //double click on tthe webelement
	}
}
