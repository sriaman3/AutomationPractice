package com.designpattern;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.exceloperation.BaseClass;

public class LoginPageTest extends BaseClass {
	
	LoginPageObjectClass loginobject;
	POMFactoryClass login;
	//BeforeMethod
	@BeforeTest
	public void initialize() {
		//loginobject = new LoginPageObjectClass(driver);
		login = new POMFactoryClass(driver);
	}
	
	@Test(priority=1)
	public void validateLoginUrl() {
		Assert.assertEquals(login.validateUrl(), prop.getProperty("url"));
		test = extent.createTest("validateLoginUrl").log(Status.PASS, "able to match the URL");
		//test.info("Matching the URL");
		
	}
	
	@Test(priority = 2)
	public void loginTest() {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		test = extent.createTest("loginTest").log(Status.FAIL, "not able to login");
	}

}
