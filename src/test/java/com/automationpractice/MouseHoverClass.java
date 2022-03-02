package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverClass {
	
	public static WebDriver driver; 
	
	public static void main(String[] args) throws InterruptedException {
		MouseHoverClass.mouseHover();
	}
	
	static void mouseHover() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?id_category=9&controller=category");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//*[text()='Evening Dresses'])[2]"));
		WebElement ele = driver.findElement(By.xpath("(//*[text()='Dresses'])[2]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).click(element).build().perform(); // Mouse Hover
	}

}
