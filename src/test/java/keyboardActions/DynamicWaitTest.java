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
//public class DynamicWaitTest {
//	@Test
//	public void DynamicTest() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://training-support.net/webelements/dynamic-content");
//		WebElement btn = driver.findElement(By.xpath("//button[@id = 'genButton']"));
//		btn.click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@id= 'word']"), "meaning"));
//		WebElement msg = driver.findElement(By.xpath("//h2[@id= 'word']"));
//		System.out.println(msg.getText());
//	}
//}
