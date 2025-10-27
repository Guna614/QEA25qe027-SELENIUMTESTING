//package testNgPractice;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class LoginTestTwo extends BaseClass {
//	
//	@BeforeClass
//	public void setUp() {
//		driver.get("https://training-support.net/webelements/login-form");
//		System.out.println("p2");
//	}
//	
//	@Test
//	public void login() {
//		driver.findElement(By.id("username")).sendKeys("Admin");
//		driver.findElement(By.id("password")).sendKeys("Password");
//		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
//		String msg = driver.findElement(By.xpath("//h2")).getText();
//		Assert.assertNotEquals(msg, "Welcome Back, Admin!");
//
//	}
//}