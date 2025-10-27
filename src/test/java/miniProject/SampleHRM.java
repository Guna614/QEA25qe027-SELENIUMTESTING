package miniProject;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleHRM {
	@Test
	public void hrmMiniProject() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//enter user name and password and click login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Username']")));
		userName.click();
		userName.sendKeys("Admin");
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
		passwordField.sendKeys("admin123");
		driver.findElement(By.xpath("//button[text() = ' Login ']")).click();
		
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		System.out.println("URL after login: " + driver.getCurrentUrl());
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
		System.out.println(dashboard.getText());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"))).click();
		
		WebElement jobMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Job ']")));
		jobMenu.click();
		
		List<WebElement> jobOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class = 'oxd-dropdown-menu' and @role = 'menu' ]//a")));
		jobOptions.forEach(e->{
			System.out.println(e.getText());
		});
		
		boolean isJobTitles = false;
		for(WebElement l : jobOptions){
		    if(l.getText().equals("Job Titles")){
		        l.click();
		        isJobTitles = true;
		        System.out.println("Clicked on Job Titles");
		        break;
		    }
		}
		if(!isJobTitles) {
			System.out.println("Job titles is not available");
			driver.quit();
			return;
		}
		
		System.out.println("-------List of All Jobs Available:");
		WebElement jobTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-table-body")));
		System.out.println(jobTable.getText());
		
		WebElement addButton = driver.findElement(By.xpath("//button[text() = ' Add ']"));
		addButton.click();
		
		WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")));
		inputField.click();
		inputField.sendKeys("Automation Tester");
		
		

	     WebElement saveButton = driver.findElement(By.xpath("//button[text() = ' Save ']")); // Use correct locator
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
	     saveButton.click();
	     
	     driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	     driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
	     driver.quit();

	}

}
