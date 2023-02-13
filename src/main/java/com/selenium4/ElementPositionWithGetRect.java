package com.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementPositionWithGetRect {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		WebElement ele = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
		System.out.println(ele.getRect().getWidth());
	}

}

/*
 * Selenium 3- getLocation() -> x & y offset 
 *  getSize() -> width & height
 * 
 * Selenium 4 -> getRect(): it is a combination of getLocation() & getSize()
 */
