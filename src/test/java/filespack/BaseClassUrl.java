package filespack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClassUrl {
		WebDriver driver;
		@BeforeSuite
		public void suite1() {
			driver = new ChromeDriver();
		}
		
//		public void quit() {
//			driver.quit();
//		}

}
