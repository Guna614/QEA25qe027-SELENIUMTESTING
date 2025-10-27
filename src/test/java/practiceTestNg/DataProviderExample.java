package practiceTestNg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import filespack.ReadxlData;

public class DataProviderExample {
	
	WebDriver driver = new ChromeDriver();


    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
//        return new Object[][] {
//            {"guna123", "pass@123"},
//            {"surya456", "pass@456"},
//            {"katakam789", "pass@789"}
//        };
    	ReadxlData read=new ReadxlData();
    	return read.readXlData();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Testing login with:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add login logic here
        
    }
}