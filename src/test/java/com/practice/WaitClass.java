package com.practice;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitClass {

	public  WebDriver driver;
	public static WaitClass wait;
	
	public static void main(String[] args) {
		
		wait = new WaitClass();
		wait.explicitWait();
	}
	
	 void implicitWait() {
		 
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/alerts");
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		 driver.findElement(By.xpath("(//*[text()='Click me'])[1]")).click();
	}
	 
	 void explicitWait() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://demoqa.com/automation-practice-form");
		 By ele1 =  By.xpath("//*[@id= 'react-select-3-input']/following-sibling::div");
		 System.out.println(driver.findElement(ele1).isEnabled());
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,200)"); 
		 
		 //Explicit Wait
		 WebElement ele2  = wait.explictWait(driver, 5, ele1);
		 
	 }
	 
	 //Generic methods
	 public WebElement explictWait(WebDriver driver1, int time, By element) {
		 WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(time));
		 WebElement elemnt = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		 System.out.println(elemnt.getTagName());
		 return elemnt;
	 }
	 
}
