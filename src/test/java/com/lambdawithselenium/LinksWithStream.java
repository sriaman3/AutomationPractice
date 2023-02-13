package com.lambdawithselenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksWithStream {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://www.freshworks.com/");
		//List<WebElement> list1 = driver.findElements(By.cssSelector("ul.footer-nav li"));
		
		List<String> list = new ArrayList<String>();
		
		//list1.stream().forEach(ele -> list.add(ele.getText()));
		//list.forEach(System.out::println);
		
		//list1.forEach(ele -> list.add(ele.getText()));
		//list.forEach(System.out::println);
		
		driver.findElements(By.cssSelector("ul.footer-nav li")).stream().forEach(ele -> list.add(ele.getText()));
		list.forEach(System.out::println);
	}

}
