package mvnex;

import java.io.IOException;
import java.util.Arrays;

import com.cognizant.TESTNG.ReadxlData;

//import seleniumGrid.LoginTest;

public class ReadData {
	public static void main(String[] args) throws IOException {
		ReadxlData read = new ReadxlData();
		Object[][] xlData = read.readXlData("C:\\Users\\2440634\\OneDrive - Cognizant\\Desktop\\DataProvider.xlsx");
		System.out.println(Arrays.deepToString(xlData));
//		LoginTest l=new LoginTest();
	}
}
