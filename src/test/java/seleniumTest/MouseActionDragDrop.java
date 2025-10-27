//package seleniumTest;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class MouseActionDragDrop {
//	@Test
//	public void testAutomation() throws InterruptedException{
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://training-support.net/webelements/drag-drop");
//		Actions actions = new Actions(driver);
//		WebElement source = driver.findElement(By.id("ball"));
//		WebElement zone1 = driver.findElement(By.id("dropzone1"));
//		
//		actions.dragAndDrop(source, zone1).perform();
//		actions.clickAndHold(source).moveToElement(zone1).release().perform();
//		Thread.sleep(2000);
//		
//		WebElement zone2 = driver.findElement(By.id("dropzone2"));
//		
//		actions.dragAndDrop(source, zone2).perform();
//		actions.clickAndHold(zone1).moveToElement(zone2).release().perform();
//	}
//
//}
