package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		DragDropClass.dragDropClick();
	}
	
	static void dragDropClick() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/dragabble");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//*[text()='Drag me']"));
		
		
		  Point point = ele.getLocation(); 
		  System.out.println(point.getX());
		  System.out.println(point.getY());
		 
		
		Actions act= new Actions(driver);
		act.dragAndDropBy(ele, 417, 296).build().perform();
	}
	
	static void dragDropClicks() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/dragabble");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Axis Restricted']"));
		ele.click();
		
		WebElement from = driver.findElement(By.xpath("//*[text()='Only X']"));
		WebElement to = driver.findElement(By.xpath("//*[text()='Only Y']"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		
	}
}
