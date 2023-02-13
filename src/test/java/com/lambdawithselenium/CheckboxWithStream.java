package com.lambdawithselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxWithStream {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		
		List<WebElement> radioButton = driver.findElements(By.xpath("(//*[@class='custom-control custom-checkbox custom-control-inline']/child::label)"));
		
		radioButton.stream().filter(ele -> ele.getText().contains("Sports")).forEach(ele -> ele.click());
		                               /****OR****/
		radioButton.stream().filter(ele -> ele.getText().contains("Others")).findAny().get().click();
										/****OR****/
		radioButton.forEach(ele -> ele.click());
		 
	}

}
