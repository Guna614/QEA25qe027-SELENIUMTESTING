//package seleniumTest;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class Activity18 {
//	@Test
//	public void multiSelectEx() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://training-support.net/webelements/selects");
//		System.out.println(driver.getTitle());
//		WebElement ele = driver.findElement(By.xpath("//select[@multiple]"));
//		Select multipleoptions = new Select(ele);
//
//	    multipleoptions.selectByVisibleText("JavaScript");
//	    multipleoptions.selectByIndex(3);
//	    multipleoptions.selectByIndex(4);
//	    multipleoptions.selectByIndex(5);
//	    multipleoptions.selectByValue("nodejs");
//	    multipleoptions.deselectByIndex(4);
//	    
//	    Thread.sleep(5000);
//	    driver.quit();
//		
//	}
//}
