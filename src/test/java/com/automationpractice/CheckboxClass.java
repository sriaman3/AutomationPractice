package com.automationpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		CheckboxClass.clickOnCheckbox("Sports");
	}
	
	static void clickOnCheckbox() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='custom-control custom-checkbox custom-control-inline']/child::label)[1]")).click();
	}
	
	static void clickOnCheckbox(String checkboxLabel) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		if(checkboxLabel.trim().isEmpty()) {
			System.out.println(checkboxLabel + "String is null");
		}else {
			driver.findElement(By.xpath("//*[contains(text(),'" + checkboxLabel + "')]")).click();
		}
	}
	
	static void clickOnCheckboxes(String radioLabel) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		List<WebElement> radioButton = driver.findElements(By.xpath("(//*[@class='custom-control custom-checkbox custom-control-inline']/child::label)"));
		
		for(int i=0;i<radioButton.size();i++) {
			
			 WebElement ele=radioButton.get(i);
			 
             String cB=ele.getText();
            
             if(cB.contains(radioLabel)) {
            	 ele.click();
             }
		}
	}
}
