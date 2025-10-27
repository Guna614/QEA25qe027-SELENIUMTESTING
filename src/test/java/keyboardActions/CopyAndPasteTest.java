//package keyboardActions;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class CopyAndPasteTest {
//	@Test
//	public void copyNpaste() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://training-support.net/webelements/dynamic-attributes");
//		driver.manage().window().maximize();
//		
//		WebElement fullNameField = driver.findElement(By.xpath("//input[@placeholder = 'Full name']"));
//		fullNameField.sendKeys("Guna Surya Kumar");
//		fullNameField.sendKeys(Keys.CONTROL, "a");
//		fullNameField.sendKeys(Keys.CONTROL, "c");
//		
//		WebElement emailField = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
//		
//		emailField.sendKeys(Keys.CONTROL, "v");
//		fullNameField.sendKeys(Keys.CONTROL, "a");
//		emailField.sendKeys("@gmail.com");
//		
//		WebElement addDetailsField = driver.findElement(By.xpath("//textarea[@id = '332c-additional-details-28cf']"));
//		addDetailsField.sendKeys(Keys.CONTROL, "v");
//		fullNameField.sendKeys(Keys.CONTROL, "a");
//		
//		fullNameField.sendKeys(Keys.BACK_SPACE);
//	}
//	@Test
//	public void keyActions() {
//	WebDriver driver = new ChromeDriver();
//	driver.get("https://training-support.net/webelements/dynamic-attributes");
//	driver.manage().window().maximize();
//	
//	WebElement fullNameField = driver.findElement(By.xpath("//input[@placeholder = 'Full name']"));
//	WebElement emailField = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
//	fullNameField.sendKeys("Guna Surya Kumar");
//	WebElement btn = driver.findElement(By.xpath("//button[text() = 'Submit']"));
//	Actions actions = new Actions(driver);
//	actions.keyDown(fullNameField, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
//	
//	actions.keyDown(emailField, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).click(btn).perform();
//	}
//}
