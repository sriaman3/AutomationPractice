package com.exceloperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	ExcelReading reader = new ExcelReading();
	public static Properties prop;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	static {
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\ScreenShot\\" + "Aman.html");
		reporter.config().setDocumentTitle("Automation test Report");
		reporter.config().setReportName("LoginTestReport");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	// BeforeMethod
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

}
