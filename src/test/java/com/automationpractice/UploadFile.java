package com.automationpractice;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		UploadFile.uploadFile();
	}

	static void uploadFile() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id ='uploadPicture']"));
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		element.sendKeys("C:\\Users\\sriam\\OneDrive\\Desktop\\test.txt");

	}

}
