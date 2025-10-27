package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import com.pages.LoginPageClass;
 
public class LoginPomTest {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(dependsOnMethods = "loginTest")
	public void loginSuccess() {
		LoginSuccessPage page = new LoginSuccessPage(driver);
		Assert.assertEquals(page.getTextOfHeader(), "Welcome Back, Admin!");
		driver.quit();
	}
	@Test
	public void loginTest() {
		driver.get("https://training-support.net/webelements/login-form");
		LoginPageClass loginPage = new LoginPageClass(driver);
		loginPage.enterUsername("admin");
		loginPage.enterPassword("password");
//		LoginSuccessPage p = loginPage.clickOnBtn();
//		
//		p.getTextOfHeader();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs("Selenium: Login Success!")));
	}
}