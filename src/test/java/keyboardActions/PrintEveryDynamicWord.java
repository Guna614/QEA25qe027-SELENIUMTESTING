//package keyboardActions;
//
//import java.time.Duration;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//
//public class PrintEveryDynamicWord {
//		WebDriver driver;
//		@Test
//		public void openPage() {
//			driver=new ChromeDriver();
//			driver.get("https://training-support.net/webelements/dynamic-content");
//			driver.findElement(By.id("genButton")).click();
//			WebElement ele = driver.findElement(By.id("word"));
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOf(ele));
//			
//			String text=ele.getText();
//			String text1="";
//			while(text.length()!=0) {
//				if(!text.equals(text1)) 
//				System.out.println(text);
//				text1=text;
//				text=ele.getText();
//			}
//		}
//	}
