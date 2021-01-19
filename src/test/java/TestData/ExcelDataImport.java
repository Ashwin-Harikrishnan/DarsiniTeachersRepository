package TestData;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataImport {
	String excelPath = "E:\\Users\\Ashwin Harikrishnan\\eclipse-workspace\\com.darsiniteacher\\Excel\\DarsiniTeachers.xlsx";
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static Cell cell;
	FileInputStream inFile;
	static FileOutputStream outFile;
	static String cellData = "";

	public void readExcel(String sheetName) {
		try {
			System.out.println("Entered readExcel method");
			inFile = new FileInputStream(excelPath);
			//outFile = new FileOutputStream(excelPath);
			wb = new XSSFWorkbook(inFile);
			sh= wb.getSheet(sheetName);			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("readExcel Failed");
			
		}
	}
	
	public static String getValue(int i, int j) {
		try {
			System.out.println("Entered getValue method");
			cellData = sh.getRow(i).getCell(j).toString();
		}catch(Exception e){
			//cellData = "";
		
		}
		return cellData;
	}
	
	public static String setValue(int i, int j, String cellValue) {
		try {
			System.out.println("Entered Set Value method");
			sh.getRow(i).createCell(j).setCellValue(cellValue);
			wb.write(outFile);
			wb.close();
			outFile.flush();
			outFile.close();
		}catch(Exception e){
			//cellData = "";
				}
		return cellData;
	}
}


