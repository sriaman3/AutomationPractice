package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest {
	
	@Test(groups= {"Smoke"})
	public void startCar() {
		System.out.println("Start Car");
		Assert.fail();
	}
	
	@Test(groups= {"Sanity"})
	public void driveCar() {
		System.out.println("Drive Car");
	}
	@Test(groups= {"Sanity"})
	public void stopCar() {
		System.out.println("Stop Car");
	}
	@Test(groups= {"Smoke"})
	public void parkCar() {
		System.out.println("Park Car");
	}


}
