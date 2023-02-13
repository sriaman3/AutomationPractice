package com.lambdawithselenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWithJava8 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		/*****Older Way****/
		/*
		 * for (WebElement webElement : list) {
		 * System.out.println(webElement.getText()); }
		 */
		
		/*****With foreach loop****/
		
		//list.forEach(ele -> System.out.println(ele.getText()));
		
		/*****With stream and filter****/
		
		/*
		 * List<String> str = list.stream().filter(ele ->
		 * !ele.getText().equals("")).map(ele ->
		 * ele.getText()).collect(Collectors.toList()); str.forEach(ele ->
		 * System.out.println(ele));
		 */
		
		/*****get first data****/
		
		/*
		 * String str1 = list.stream().filter(ele ->
		 * !ele.getText().equals("")).findFirst().get().getText();
		 * System.out.println(str1);
		 */
		
		/*****get Any data****/
		/*
		 * String findAny = list.stream().filter(ele ->
		 * !ele.getText().equals("")).findAny().get().getText();
		 * System.out.println(findAny);
		 */
		
		/*****with multiple conditions-> exclude blank texts and which starts with or contains Amazon****/
		
		/*
		 * List<String> str = list.stream().filter(ele -> !ele.getText().equals("") &&
		 * ele.getText().startsWith("Amazon")). map(ele ->
		 * ele.getText()).collect(Collectors.toList()); str.forEach(ele ->
		 * System.out.println(ele));
		 */
		/*****want proper text that does not have any blank space****/
		
		List<String> str = list.stream().filter(ele -> !ele.getText().isEmpty()).filter(ele -> !ele.getText().startsWith(" ")).
		map(ele -> ele.getText().trim()).collect(Collectors.toList());
		
		str.forEach(ele -> System.out.println(ele));
		
	}

}
