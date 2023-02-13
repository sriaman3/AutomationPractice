package com.selenium4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		WebElement ele  =  driver.findElement(By.xpath("//*[contains(text(),'Username')]"));
		
		WebElement ele1  = driver.findElement(RelativeLocator.with(By.tagName("p")).above(ele));
		System.out.println(ele1.getText());
		
		RelativeLocators.listOfWebElements();
		
	}
	
	
	public static void listOfWebElements() {
		List<WebElement> allSocialMedia = driver.findElements(RelativeLocator.with(By.tagName("a")).near(By.xpath("//*[contains(@class, 'orangehrm-login-footer-sm')]")));
		
		for(WebElement ele :allSocialMedia) {
			System.out.println(ele.getTagName());
		}
	}

}
