package com.listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.listener.CustomListener.class)
public class ListenerTest {
	
	public static WebDriver driver;
	
	@Test
	public void test1() {
		System.out.println("test1");
		Assert.assertEquals("A", "A");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		Assert.assertEquals("A", "B");
	}

	
	@Test
	public void test3() {
		System.out.println("test3");
		throw new SkipException("This is exception");
	}

}
