package com.lambdawithselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleStream {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.naukri.com/");
		
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform(); //will press CTRL from keyboard
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		action.keyUp(Keys.CONTROL).build().perform(); //will be keyup of CTRL button
		String title = WindowHandleStream.switchToWindowTest(driver, "Register on Naukri.com: Apply to Millions of Jobs Online");
		
		System.out.println(title);

		//WindowHandleStream.newFeature();
	}
	
	
	/*
	 * public static void newFeature() throws InterruptedException { WebDriver
	 * driver = WebDriverManager.chromedriver().create();
	 * driver.get("https://www.flipkart.com/"); driver.manage().window().maximize();
	 * driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
	 * Thread.sleep(2000); //driver.switchTo().newWindow(WindowType.WINDOW);
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath("//*[contains(@class,'IiD88i _351hSN')]/input")).
	 * sendKeys("Aman"); }
	 */
	
	
	public static String switchToWindowTest(WebDriver driver, String title) {
		
		return driver.getWindowHandles().stream().map(handler -> driver.switchTo().window(handler).getTitle())
		.filter(ele ->  ele.contains(title)).findFirst().orElseThrow(()-> 
		{
			throw new RuntimeException("No Such Window");
		});
		
	}

}
