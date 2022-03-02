package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		CheckboxClass.getTableData();
		
	}
	
	//getTableHeader
	//countRowsAndColumns
	//getLastRow
	//getTableData
	
	public static void getTableHeader() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th"));
		System.out.println(ele.size());
		for(WebElement ele1 :ele) {
			System.out.println(ele1.getText());
		}
	}
	
	public static void countRowsAndColumns() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		System.out.println(row.size());
		
		List<WebElement> cells = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td"));
		System.out.println(cells.size());
	}
	
	public static void getLastRow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		
		String str = driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[last()]")).getText();
		
		System.out.println(str);
	}
	
	public static void getTableData() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th"));
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		
		List<WebElement> cells = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td"));
		
		for(int i=1; i<=row.size();i++) {
			for(int j=1; j<=cells.size();j++) {
				 if(j<=ele.size()) {
					 System.out.print("  "+ driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText());
				 }
				 
			   }
			System.out.println();
		}
		
	}
	
}
