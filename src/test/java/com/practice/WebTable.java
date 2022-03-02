package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebTable table = new WebTable();
		table.getTableData();
		//"Bata India"
	}
	
	public void getTableHeader() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th"));
		System.out.println(ele.size());
		for(WebElement ele1 :ele) {
			System.out.println(ele1.getText());
		}
		
	}
	
	public void countRowsAndColumns() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th"));
		System.out.println(ele.size());
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		System.out.println(row.size());
		
		
	}
	
	public void getRowPosition(String str) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		
		for(int i=1; i<=row.size();i++) {
			String firstText = driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr["+i+"]/td/a")).getText();
			if(str.equalsIgnoreCase(firstText)) {
				System.out.println(i);
			}else {
				System.out.println("Not found");
			}
		}
		
	}
	
	public void getLastRow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[last()]/td"));
		for(WebElement e : ele) {
			System.out.println(e.getText());
		}
	}
	
	public void getTableData() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
		List<WebElement> th = driver.findElements(By.xpath("//*[@class='dataTable']/thead/tr/th"));
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td"));
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		
		for (int i = 1; i <= row.size(); i++) {

			   for (int j = 1; j <= ele.size(); j++) {
				   if(j<=th.size()) {
				   System.out.print("  "+ driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText());
				   }
			   }
			   System.out.println();
			   System.out.println();
		}
		
	}
}
