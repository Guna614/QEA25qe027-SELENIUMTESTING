//APACHI POI this is used to read and write data in xl files

package filespack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class WriteDataToXl {
	public static void writeData() throws IOException {
		FileOutputStream output = new FileOutputStream(new File("C:/Users/Dilip/Desktop/users.xlsx"));
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("user-details");
		String[][] usersDetails = {
				{"usernmae", "address"},
				{"dilip", "hyd"},
				{"ramesh", "mumbai"},
				{"rajesh", "bangalore"}
				
		};
		
		for (int i = 0; i < usersDetails.length; i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < usersDetails[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(usersDetails[i][j]);
			}
		}
		
		book.write(output);
		output.close();
	}
	public static void main(String[] args) throws IOException {
		writeData();
	}
}