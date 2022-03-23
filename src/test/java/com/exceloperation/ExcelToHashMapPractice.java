package com.exceloperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMapPractice {

	public static FileInputStream fileInputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path = null;
	
	public static HashMap<String, List<String>> readDataFromExcelInKeyValue() throws IOException {
		String key = null, value = null;
		
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\datadriventesting\\TestData.xlsx");
		workBook = new XSSFWorkbook(fileInputStream);
		sheet = workBook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		List<String> list = new ArrayList<String>();
		
		HashMap<String, List<String>> data = new HashMap<String, List<String>>();
		DataFormatter formatter = new DataFormatter();
		
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++) {
				
			 key = sheet.getRow(0).getCell(i).getStringCellValue();
			 
				 for(int j=1;j<=rowCount;j++) {
					 value = formatter.formatCellValue(sheet.getRow(j).getCell(i));
					 list.add(value);
					 data.put(key, new ArrayList<String>(list));
				 }
				 list.clear();
		}
		System.out.println(data.get("Email").get(0));
		return data;
	}
	
	public static void main(String args[]) throws IOException {
		
		HashMap<String, List<String>> data = new HashMap<String, List<String>>();
		data = readDataFromExcelInKeyValue();
		
		System.out.println(data.get("Email").get(1));
		
		
		 for(Map.Entry entry : data.entrySet()) {
		 System.out.println(entry.getKey()+"  "+ entry.getValue()); }
		 
	}
}
