package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String getTestDate(int rowNumber , int cellNumber) throws InvalidFormatException, IOException {
		
		//Create File class Object.
		
		File file = new File(" ");
		
		//Create Workbook Object.
		
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		//Create Sheet Object.
		
		Sheet sheet = (Sheet) book.getSheetAt(0);
		
		
		//Specify the row and cell number.
		
		return ((XSSFSheet) sheet).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	
	}

}
