//package seleniumTest;
//import java.time.Duration;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
////import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class GoogleTest {
//	
//	@Test
//	public void openGooglePage() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		WebElement input = driver.findElement(By.id("APjFqb"));
//		input.sendKeys("Hello Google");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[text()= 'Stay signed out']/parent::span/parent::div/parent::div")).click();
//		
//		
//		
//		FluentWait<WebDriver> wait = null;
//		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Google Search'])[1]")));
//		ele.click();
//		System.out.println(ele);
//		input.sendKeys(Keys.ENTER);
//
//		// By using name locator 
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement searchButton = wait.until(
//            ExpectedConditions.elementToBeClickable(By.name("btnK"))
//        );
//        searchButton.click();
//
//	}
//}
