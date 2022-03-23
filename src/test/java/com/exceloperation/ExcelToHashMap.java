package com.exceloperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {

	public static FileInputStream fileInputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path = null;
	
	public static HashMap<String, String> readDataFromExcelInKeyValue() throws IOException {
		String key = null, value = null;
		
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\datadriventesting\\TestData.xlsx");
		workBook = new XSSFWorkbook(fileInputStream);
		sheet = workBook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		HashMap<String, String> data = new HashMap<String, String>();
		DataFormatter formatter = new DataFormatter();
		
		for(int i=0;i<=rowCount;i++) {
				 key = sheet.getRow(i).getCell(0).getStringCellValue();
				 value = formatter.formatCellValue(sheet.getRow(i).getCell(1));
				 data.put(key, value);
		}
		
		return data;
	}
	
	public static void main(String args[]) throws IOException {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data = readDataFromExcelInKeyValue();
		
		System.out.println(data.get("Email"));
		
		for(Map.Entry entry : data.entrySet()) {
			System.out.println(entry.getKey()+"  "+ entry.getValue());
		}
	}
}
