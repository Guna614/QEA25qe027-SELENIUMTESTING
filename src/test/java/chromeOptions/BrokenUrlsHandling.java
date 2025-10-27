//package chromeOptions;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BrokenUrlsHandling {
//	@Test
//	public void brokenUrls() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.myntra.com/");
//		List<WebElement> anchorTags = driver.findElements(By.cssSelector("a"));
//		for(WebElement a: anchorTags) {
//			String link = a.getAttribute("href");
//			System.out.println(link);
//		}
//	}
//}
