package com.automation;

public class CheckboxClass {
	
	
	public static void main(String[] args) {
		
		String str = "JavaSelenium";
		
		for(int i=0; i<=str.length();i++) {
			if(i%2!=0) {
				System.out.println(str.charAt(i));
			}
		}
		
	}
	
	
	
}
