//package testNgPractice;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class Login extends BaseClass{
//	
//	@BeforeClass
//	public void setUp() {
//		driver.get("https://training-support.net/webelements/login-form");
//		System.out.println("p1");
//	}
//	
//	@Parameters({"username" , "password"})
//	@Test
//	public void login(String username, String password) {
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		System.out.println("program1");
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h2"), "Welcome Back, Admin!"));
//		String msg = driver.findElement(By.xpath("//h2")).getText();
//		Assert.assertEquals(msg, "Welcome Back, Admin!");
//	}
//	@Test
//	public void sampleTwo() {
//		System.out.println("Hello1");
//	}
//}
