package multipleTabs;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {
	@Test
	public void multipleWindows() throws InterruptedException {
		ChromeOptions options = new  ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.myntra.com/");
		
		WebElement searchField =  driver.findElement(By.xpath("//input[@placeholder = 'Search for products, brands and more']"));
				searchField.sendKeys("shoes");
				searchField.sendKeys(Keys.ENTER);
				
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class = 'results-base']/li)[2]"))).click();
		
		String mainpage = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> multipleHandles = driver.getWindowHandles();
		for(String handle : multipleHandles) {
			if (!handle.equals(mainpage)) {
				driver.switchTo().window(handle);			
				
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				
			}
		}

		
		driver.switchTo().window(mainpage);
		driver.close();
		
		
	}
}
