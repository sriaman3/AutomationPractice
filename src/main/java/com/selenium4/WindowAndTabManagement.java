package com.selenium4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAndTabManagement {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		WindowAndTabManagement.openAndSwitchToNewWindow();
		
		//driver.switchTo().newWindow(WindowType.TAB); // open new tab
		
		//WebDriver win = driver.switchTo().newWindow(WindowType.WINDOW);
		//win.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		
	}
	
	public static void openAndSwitchToNewWindow() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB).get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		WebElement ele  =  driver.findElement(By.xpath("//*[contains(text(),'Username')]"));
		
		System.out.println(ele.getTagName());
		
		Set<String> allWindowTabs = driver.getWindowHandles();
		//List<String>list = new ArrayList<>(allWindowTabs);
		
		Iterator<String> itr = allWindowTabs.iterator();
		String firstWindow = itr.next();
		
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getCurrentUrl());
		
		//driver.switchTo().window(list.get(1));
		
	}

}
