package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WindowHandle.windowHandle();
	}
	
	static void windowHandle() throws InterruptedException {
		WindowHandle win = new WindowHandle();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		
		// It will return the parent window name as a String
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		Set<String> allWindow = driver.getWindowHandles();
		
		for(String id : allWindow) {
			System.out.println(id);
		}
		Thread.sleep(2000);
		
		Iterator<String> itr = allWindow.iterator();
		while(itr.hasNext()) {
			String childID = itr.next();
			Thread.sleep(2000);
			if(!parentWindow.equalsIgnoreCase(childID)) {
				driver.switchTo().window(childID);
				Thread.sleep(2000);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				win.createAccount();
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		driver.quit();
	}
	
	public void createAccount() {
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Aman");
	}
	
	

}
