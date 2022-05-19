package com.automationpractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		AlertClass.alertPromptBox();
	}

	static void alert() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//*[text()='Click me'])[1]")).click();

		Thread.sleep(2000);

		driver.switchTo().alert().accept();

	}

	static void alertConformBox() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//*[text()='Click me'])[3]")).click();

		Thread.sleep(2000);

		driver.switchTo().alert().dismiss();

	}

	static void alertPromptBox() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//*[text()='Click me'])[4]")).click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Inku");
		alert.accept();

	}

}
