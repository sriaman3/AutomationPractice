package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipClass {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		TooltipClass.tooltipClass();
	}
	
	static void tooltipClass() throws InterruptedException {
		//*[@class='tooltip-inner']
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?id_category=10&controller=category#/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//*[text()='Dresses'])[2]"));
		//RelativeLocator.with(By.tagName("")).above(ele);
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform(); // Mouse Hover
		
		String tooltip = driver.findElement(By.xpath("(//*[text()='Casual Dresses'])[2]")).getText();
		System.out.println(tooltip);
	}
	
	

}
