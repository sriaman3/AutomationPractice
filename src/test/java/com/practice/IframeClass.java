package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		IframeClass.iframe();
	}
	
	
	static void iframe() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.id("frame1"));
		//switch to frame by element
		driver.switchTo().frame(ele);
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		
		//Switching back to the main window
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[contains(text(),'Forms')]")).click();
	}
}
