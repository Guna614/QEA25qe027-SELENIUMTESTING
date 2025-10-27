package filespack;
import java.io.IOException;
//import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends BaseClassUrl{

	@BeforeClass
	public void setUp() {
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@DataProvider(name = "credentials")
	public Object[][] dataProducer() throws IOException{
		ReadxlData data = new ReadxlData();
		return data.readXlData();
	};
	
	@Test(dataProvider = "credentials")
	public void login(String username, String password, String expectedResults) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String targetText;
		Thread.sleep(3000);
		if(username.equals("admin") && password.equals("password")) {
			targetText = driver.findElement(By.xpath("//h2")).getText();
		} else {
			targetText = driver.findElement(By.id("subheading")).getText();
		}
		
		Assert.assertEquals(targetText, "Welcome Back, Admin!");
	}
	
//	@AfterTest
//	public void quit() {
//		driver.quit();
//	}
}