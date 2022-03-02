package com.automationpractice;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotationClass {
	
	public WebDriver driver;
	
	@BeforeSuite
	void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}

	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Mrthod");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test
	void btest() {
		System.out.println("First Test");
	}
	@Test
	void atest() {
		System.out.println("First Test1");
	}

}
