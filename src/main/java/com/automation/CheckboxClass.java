package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxClass {
	
	
	
	public static void main(String[] args) {
		
		
		  WebDriver driver = WebDriverManager.chromedriver().create();
		  driver.get("http://automationpractice.com/index.php");
		 
	}
		
	


}