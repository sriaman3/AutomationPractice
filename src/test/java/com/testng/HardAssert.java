package com.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	Logger logger = LoggerFactory.getLogger(HardAssert.class);
	
	@Test
	public void softAssert(){
		System.out.println("softAssert Method Was Started");
		Assert.assertTrue(true);
		logger.info("This is passed");
		System.out.println("softAssert Method Was Executed");
	}
	
	@Test
	public void softAssert1(){
		System.out.println("softAssert Method Was Started");
		Assert.assertFalse(true);
		System.out.println("softAssert Method Was Executed");
		
	}

}
