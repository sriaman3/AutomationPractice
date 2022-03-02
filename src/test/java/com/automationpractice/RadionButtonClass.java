package com.automationpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadionButtonClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		RadionButtonClass.clickOnRadioButtons("Custom");
	}
	
	
	static void clickOnRadioButton() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(), 'Create New Account')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='_5k_2 _5dba']/child::label)[1]")).click();
	}
	
	static void clickOnRadioButton(String radioLabel) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(), 'Create New Account')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(text(),'" + radioLabel + "')]")).click();  
	}
	
	static void clickOnRadioButtons(String radioLabel) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(), 'Create New Account')]")).click();
		
		Thread.sleep(3000);
		List<WebElement> radioButton = driver.findElements(By.xpath("(//*[@class='_5k_2 _5dba']/child::label)"));
		
		for(int i=0;i<radioButton.size();i++) {
			radioButton.get(i).click();
		}
	}
}
