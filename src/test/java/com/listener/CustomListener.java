package com.listener;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

	// This belongs to ITestListener and will execute before starting of Test set/batch
	public void onStart(ITestContext context) {
		System.out.println("Start test execution.." + context.getName());
	}

	// This belongs to ITestListener and will execute after starting of Test set/batch
	public void onFinish(ITestContext context) {
		System.out.println("Finish test execution.." + context.getName());
	}

	// This belongs to ITestListener and will execute before the main test start @Test
	public void onTestStart(ITestResult result) {
		System.out.println("Started tests.." + result.getName());
	}

	// This belongs to ITestListener and will execute when the test is skipped
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped tests.." + result.getName());
	}

	// This belongs to ITestListener and will execute when the test is failed
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed tests.." + result.getName());
		// Using GregorianCalendar to fetch the time details
		Calendar cal = new GregorianCalendar();
		// Month value is always 1 less than actual. For February, MONTH would return 1
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		TakesScreenshot takesScreenshot = (TakesScreenshot) ListenerTest.driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\ScreenShot\\" + result.getName()
					+ "_" + date + "_" + year + "_" + sec + ".png"));
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// not so important
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

}
