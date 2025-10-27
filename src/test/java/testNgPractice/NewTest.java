//package testNgPractice;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class NewTest {
//	WebDriver driver;
//	@BeforeClass
//	public void beforeClassMethod() {
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		System.out.println("before class");
//	}
//	
//	@Test
//	public void f() {
//		SoftAssert soft = new SoftAssert();
//		String title = driver.getTitle();
//		WebElement searchBar = driver.findElement(By.name("q"));
//		soft.assertFalse(searchBar.isDisplayed());
//	}
//	
//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		driver.quit();
//	}
//}
