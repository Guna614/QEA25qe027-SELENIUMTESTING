//package testNgPractice;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.testng.Assert.*;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//public class PreacticeExampleOrangeHRM {
//	WebDriver driver = new ChromeDriver();
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	
//	@BeforeClass
//	public void beforeClass() {
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		System.out.println("before class");
//	}
//	
//	@Test
//	public void login() {
//		
//		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Username']")));
//		usernameField.sendKeys("Admin");
//		WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
//		passwordField.sendKeys("admin123");
//		
//		driver.findElement(By.xpath("//button[text() = ' Login ']")).click();
//	}
//	
//	@Test(dependsOnMethods = "login")
//	public void loginCheck() {
//		SoftAssert soft = new SoftAssert();		
//		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text() = 'Dashboard']")));
//		String title = driver.getTitle();
//		Assert.
//		assertTrue(dashboard.isDisplayed());
//		System.out.println("dashboard is there");
//		soft.assertAll();
//	}
//}
