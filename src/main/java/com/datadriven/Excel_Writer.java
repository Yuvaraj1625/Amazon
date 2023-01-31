package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.properties.Configuration_Helper;

public class Excel_Writer {
	
	private void createdata(String name,int row,int cell) throws IOException, InterruptedException {

		File f= new File("C:\\Users\\kaaviyan\\Desktop\\DataDriven.xlsx");
		
		FileInputStream fi=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fi);
		
		Sheet s = w.createSheet(name);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		
		CellType ct = c.getCellType();
		
		FileOutputStream fo=new FileOutputStream(f);
		
		
		
		
	}

}
