//package testNgPractice;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//	
//public class Activity2 {
//	WebDriver driver = new ChromeDriver();
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	
//	@Test
//	public void openBrowser() {
//		driver.get("https://training-support.net/webelements/simple-form");
//		System.out.println("Navigated to page successful");
//		
//	}
//	
//	@Test (dependsOnMethods = "openBrowser")
//	public void loginTest() {
//		driver.findElement(By.id("full-name")).sendKeys("Guna");
//		driver.findElement(By.id("email")).sendKeys("Guna@gmail.com");
//		driver.findElement(By.xpath("//input[@type = 'date']")).sendKeys("23-01-2004");
//		driver.findElement(By.id("additional-details")).sendKeys("Form Submitted");
//		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
//		
//		System.out.println("From submitted successful");
//	}
//	
//	@Test (dependsOnMethods = "loginTest")
//	public void getLoginSuccessMessage() {
//		WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Your event has been scheduled!']")));
//		System.out.println(check.getText());
//		System.out.println("login success message : " + check.isDisplayed());
//	}
//}
