package com.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionClass {
	
	SoftAssert softAssertion; 
	@BeforeTest
	public void test() {
		System.out.println("Hello");
	}
	
	@Test
	public void verifyLoginFunctionality(){
		softAssertion =  new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(true);
		System.out.println("Verification of the login functionly is passed");
		System.out.println("Verification is failed");
		softAssertion.assertAll();
	}
	
	@Test
	public void softAssert1(){
		softAssertion =  new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertFalse(false);
		System.out.println("softAssert Method Was Executed");
		softAssertion.assertAll();
	}

}
