package com.pages;
 
import java.time.Duration;
//import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
 
public class LoginPageClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	WebElement buttonElement;
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String name) {
		usernameField.sendKeys(name);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public LoginSuccessPage clickOnBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
		buttonElement.click();
		return new LoginSuccessPage(driver);
	}
}