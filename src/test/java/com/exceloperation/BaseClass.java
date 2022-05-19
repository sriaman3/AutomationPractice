package com.exceloperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.listener.ListenerTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	ExcelReading reader = new ExcelReading();
	public static Properties prop;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static  String uuid;
	public static int month;
	public static int year;
	public static int sec;
	public static int min;
	public static int date;
	public static int day;
	
	public static String generateUniqueNumber() {
		 //return uuid = UUID.randomUUID().toString();
		 
		/*
		 * Random rand = new Random(); int maxNumber = 5; int randomNumber =
		 * rand.nextInt(maxNumber) + 1; return randomNumber;
		 */
		 
		 Calendar cal = new GregorianCalendar();
			// Month value is always 1 less than actual. For February, MONTH would return 1
			 month = cal.get(Calendar.MONTH);
			 year = cal.get(Calendar.YEAR);
			 sec = cal.get(Calendar.MILLISECOND);
			 min = cal.get(Calendar.MINUTE);
			 date = cal.get(Calendar.DATE);
			 day = cal.get(Calendar.HOUR_OF_DAY);
			 String value = date + "_" + year + "_" + sec;
			 return value;
	}
	
	static {
		String value = generateUniqueNumber();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\ScreenShot\\" + value + ".html");
		System.out.println(value);
		reporter.config().setDocumentTitle("Automation test Report");
		reporter.config().setReportName("LoginTestReport");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	//BeforeMethod
	@BeforeSuite
	public void setUp() throws IOException {
		readConfig();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	// BeforeMethod
	@AfterSuite
	public void tearDown() {
		driver.close();
		extent.flush();
	}

	@DataProvider(name = "userdataprovider")
	public Object[][] getExcelData() throws Exception {
		int rowNum = ExcelReading.getRowCount(System.getProperty("user.dir") + "\\TestDatas.xlsx", "Login");
		System.out.println(rowNum);
		int cellNum = ExcelReading.getCellCount(System.getProperty("user.dir") + "\\TestDatas.xlsx", "Login", rowNum);

		Object[][] empData = new Object[rowNum][cellNum];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < cellNum; j++) {
				empData[i - 1][j] = ExcelReading.getCellData(System.getProperty("user.dir") + "\\TestDatas.xlsx",
						"Login", i, j);
			}
		}
		return empData;
	}

	public void readConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/configuration/config.properties");
		prop.load(fis);
	}
	
	public static String takeScreenShot(String fileName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		String source = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		
		/*
		 * File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		 * 
		 * 
		 * String destination = System.getProperty("user.dir") +
		 * "\\ScreenShot\\" + fileName + "_" + date + "_" + year + "_" + sec + ".png";
		 * 
		 * 
		 * File finalDestination = new File(destination);
		 * //finalDestination.getAbsolutePath();
		 * FileUtils.copyFile(source,finalDestination);
		 */
		 
			 
		 
		return "data:image/jpg;base64, " + source ;
			  
			  //return destination;
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		if(ITestResult.FAILURE == result.getStatus()){
			String screenShot = takeScreenShot(result.getName());
			//test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
		}
	}
	
}
