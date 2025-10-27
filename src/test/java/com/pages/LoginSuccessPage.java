package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {
	WebDriver driver;
	
	@FindBy(tagName = "h2")
	WebElement headerText;
	
	public LoginSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTextOfHeader() {
		return headerText.getText();
	}

}
