//package seleniumTest;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class SelectClassExample {
//	@Test
//	public void multiple() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://training-support.net/webelements/selects");
//		WebElement ele = driver.findElement(By.xpath("//select[@multiple]"));
//		Select multipleoptions = new Select(ele);
//
//	    multipleoptions.selectByVisibleText("Rust");
//	    multipleoptions.selectByVisibleText("HTML");
//	    multipleoptions.selectByVisibleText("CSS");
//	    multipleoptions.selectByVisibleText("TailwindCSS");
//	    
//	  
//		
//	}
//}
