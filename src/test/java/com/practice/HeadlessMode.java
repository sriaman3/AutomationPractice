package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessMode {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080"); 
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(options);
		 //driver.manage().window().maximize();
		 driver.get("https://demoqa.com/alerts");
		 System.out.println(driver.getTitle());
	}

}
