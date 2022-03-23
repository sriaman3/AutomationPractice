package com.designpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjectClass {
	WebDriver driver;
	//Basic Approach
	By username = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='passwd']");
	By submitButton = By.xpath("//*[@id='SubmitLogin']");
	
	public LoginPageObjectClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public String validateUrl() {
		return driver.getCurrentUrl();
	}
	
	public void login(String email, String pass) {
		driver.findElement(username).sendKeys(email);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submitButton).click();
	}

}
