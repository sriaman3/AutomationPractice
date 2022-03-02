package com.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollClass {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		ScrollClass.scrollDown();
	}
	
	static void scrollDown() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,200)");  //Vertical scroll
		Thread.sleep(2000);
		//jse.executeScript("window.scrollBy(0,-200)"); 
		//jse.executeScript("window.scrollBy(200,0)");  //Horizontal scroll
		
		//WebElement ele = driver.findElement(By.xpath("(//*[@class=' css-1wa3eu0-placeholder'])[1]"));
		
		/*
		 * “arguments[0]” means first index of page starting at 0.
		 * Where an ” Element ” is the locator on the web page.
		 */
		
		//jse.executeScript("arguments[0].scrollIntoView();", ele); //scroll down the web page by the visibility of the element.
		
		/*
		 * To scroll down the web page at the bottom of the page.
		 */
		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//scroll a specific DIV
		//jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}

//args = document.getElementById("state").children[0]
