package filespack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadxlData {
	public static void main(String[] args) throws IOException {
		ReadxlData data = new ReadxlData();
		data.readXlData();
	}
	
	public Object[][] readXlData() throws IOException{
		File file = new File("C:\\Users\\2440634\\OneDrive - Cognizant\\Desktop\\DataProvider.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook book = new XSSFWorkbook(inputStream);
		Sheet sheet = book.getSheetAt(0);
		
		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i = 1; i < sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++) {
				data[i - 1][j] = row.getCell(j).toString();
				System.out.println(row.getCell(j));
			}
		}
		return data;
	}
}
