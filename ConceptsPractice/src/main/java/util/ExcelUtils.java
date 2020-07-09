package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public static int getRowCount() throws IOException {
		int row = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of Row counts are: "+row);
		return row;
	}
	
	public static void getCellStringData(int row, int col) throws IOException {
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		System.out.println(data);
	}
	
	public static void getCellNumericData(int row, int col) throws IOException {
		long Number = (long)sheet.getRow(row).getCell(col).getNumericCellValue();
		System.out.println(Number);
	}
	
	public static void getAllData(int row, int  column) throws IOException {
		System.out.println("---------------------------------");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
			try {
			System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" || ");	
			}
			catch(Exception e)
			{
				long number = (long) sheet.getRow(i).getCell(j).getNumericCellValue();
				System.out.print(number+" || ");
			}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws IOException {
		workbook = new XSSFWorkbook("D:\\Eclipse Oxygen\\Eclipse_Workspace\\ConceptsPractice\\ExcelFIles\\Book1.xlsx");
		sheet = workbook.getSheet("Sheet2");
		int column = 2;
		int row = getRowCount();
		getCellStringData(3,1);
		getCellNumericData(4,1);
		getAllData(row,column);
	}
}
