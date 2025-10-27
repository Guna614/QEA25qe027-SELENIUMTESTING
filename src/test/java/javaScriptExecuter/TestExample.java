//package javaScriptExecuter;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class TestExample {
//	@Test
//	public void search() {
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.amazon.in");
//		WebElement inputField = driver.findElement(By.id("twotabsearchtextbox"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = 'Laptops';", inputField);
//		
//	}
//}
