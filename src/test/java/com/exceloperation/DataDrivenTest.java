package com.exceloperation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DataDrivenTest extends BaseClass {
	
	@Test(dataProvider="userdataprovider")
	public void loginTest(String username, String password) {
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	}

}
