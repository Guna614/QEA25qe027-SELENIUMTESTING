//package seleniumTest;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class NewTest {
//	@Test
//	public void testAutomation() throws InterruptedException{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://training-support.net/webelements/drag-drop");
//		
//		WebElement ball = driver.findElement(By.id("ball"));
//		
//		
//		WebElement targetOne = driver.findElement(By.id("dropzone1"));
//		 zone x and y coordinates
//		int widthOfTargetOne = targetOne.getLocation().getX();
//		int heightOfTagetOne = targetOne.getLocation().getY();
//		ball x and y coordinates
//		int ballWidth = ball.getLocation().getX();
//		int ballHeight = ball.getLocation().getY();
//		int width = widthOfTargetOne - ballWidth;
//		int height = heightOfTagetOne - ballHeight;
//		
//		Actions actions = new Actions(driver);
//		actions.clickAndHold(ball).moveByOffset(width, height).release().perform();
//		Thread.sleep(2000);
//		
//		
//		WebElement targetTwo = driver.findElement(By.id("dropzone2"));
//		int widthOfTargetTwo = targetTwo.getLocation().getX();
//		int heightOfTargetTwo = targetTwo.getLocation().getY();
//
//		int width2 = widthOfTargetTwo - widthOfTargetOne;
//		int height2 = heightOfTargetTwo - heightOfTagetOne;
//
//		actions.clickAndHold(ball).moveByOffset(width2, height2).release().perform();
//		Thread.sleep(2000);
//		
//		//again to first location
//		int baseX = ballWidth;
//		int baseY = ballHeight;
//
//		int currentX = ball.getLocation().getX();
//		int currentY = ball.getLocation().getY();
//
//		int offsetX = baseX - currentX;
//		int offsetY = baseY - currentY;
//
//		actions.clickAndHold(ball).moveByOffset(offsetX, offsetY).release().perform();
//		
//		driver.close();
//		
//
//	}
//}
