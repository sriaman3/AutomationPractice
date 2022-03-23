package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionClass {
	
	SoftAssert softAssertion= new SoftAssert();
	@BeforeTest
	public void test() {
		System.out.println("Hello");
	}
	
	@Test
	public void verifyLoginFunctionality(){
		
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(true);
		System.out.println("Verification of the login functionly is passed");
		System.out.println("Verification is failed");
		softAssertion.assertAll();
	}
	
	@Test
	public void softAssert1(){
		
		System.out.println("softAssert Method Was Started");
		softAssertion.assertFalse(true);
		System.out.println("softAssert Method Was Executed");
		softAssertion.assertAll();
	}
	
	@AfterTest
	public void aftertest() {
		softAssertion.assertAll();
	}
}
