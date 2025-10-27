//package keyboardActions;
//
//import java.time.Duration;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class WaitTest {
//	@Test
//	public void fileUpload() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://v1.training-support.net/selenium/ajax");
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		WebElement btn = driver.findElement(By.xpath("//button[@class = 'ui violet button']"));
//		btn.click();
//		
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
//		WebElement msg = driver.findElement(By.tagName("h3"));
//		System.out.println(msg.getText());
//	}
//}
