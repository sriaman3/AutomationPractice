package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		DropdownClass.verifyToSelectValueFromDropdown();
	}
	
	/*
	 * Without select class, select data in dropdown
	 */
	static void verifyToSelectValueFromDropdown() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  // Narrow Type casting
		js.executeScript("location.reload(true);"); // Hard refresh
		js.executeScript("window.scrollBy(0,800)"); //Vertical scroll
		
		driver.findElement(By.xpath("(//*[@class=' css-1wa3eu0-placeholder'])[1]")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='react-select-3-input']"));
		ele.sendKeys("Haryana");
		
		js.executeScript("document.getElementById('react-select-3-option-2').click()");
	}
}


