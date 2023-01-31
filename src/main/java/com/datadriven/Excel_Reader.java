package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.properties.Configuration_Helper;

public class Excel_Reader {

	public static String value;

	public static String singleData(String name, int row, int cell) throws IOException {

		String path = Configuration_Helper.getInstanceCR().getpath();

		File f = new File(path);

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.getSheet(name);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);

		CellType ct = c.getCellType();

		if (ct.equals(CellType.STRING)) {
			value = c.getStringCellValue();

		} else if (ct.equals(CellType.NUMERIC)) {
			double nv = c.getNumericCellValue();

			int a = (int) nv;
			value = String.valueOf(a);
		}
		System.out.println(value);
		return value;

	}

	public static void multidata() throws IOException {

		File f = new File(Configuration_Helper.getInstanceCR().getpath());

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.getSheetAt(0);

		int rows = s.getPhysicalNumberOfRows();

		for (int i = 0; i < rows; i++) {

			Row r = s.getRow(i);//0 1

			int cells = r.getPhysicalNumberOfCells();

			for (int j = 0; j < cells; j++) {

				Cell c = r.getCell(j);//0 1

				CellType ct = c.getCellType();

				if (ct.equals(CellType.STRING)) {
					System.out.print(c.getStringCellValue()+" | ");

				}

			}
			System.out.println();

		}

	}
	public static void main(String[] args) throws IOException {
		multidata();
	}

}
