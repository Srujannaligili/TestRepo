package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorking {

	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public ExcelWorking(String excelPath, String sheetName) throws IOException {
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(sheetName);
	}

	static void ExcelWorkingExample() {

		int rowCount = sheet.getPhysicalNumberOfRows();
//			System.out.println(rowCount);

		double cellData = sheet.getRow(1).getCell(1).getNumericCellValue();
//			System.out.println((int)(cellData));

		DataFormatter format = new DataFormatter();
		Object object = format.formatCellValue(sheet.getRow(1).getCell(1));
//			System.out.println(object);

	}

	public static void main(String[] args) {
		ExcelWorkingExample();

	}

}
