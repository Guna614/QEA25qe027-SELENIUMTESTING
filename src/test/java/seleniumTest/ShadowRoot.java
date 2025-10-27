//package seleniumTest;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ShadowRoot {
//	@Test
//	public void shadowRootExample() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://shop.polymer-project.org/");
		
//		WebElement shopApp = driver.findElement(By.cssSelector("shop-app"));
//		SearchContext firstShadownroot = shopApp.getShadowRoot();
//		WebElement ironPages = firstShadownroot.findElement(By.cssSelector("iron-pages"));
//		WebElement shopHome = ironPages.findElement(By.cssSelector("shop-home"));
//		SearchContext search =  shopHome.getShadowRoot();
//		WebElement clickLink = search.findElement(By.cssSelector("div:nth-of-type(1) > shop-button > a"));
//		clickLink.click();
//		//using Js
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement targetElement = (WebElement) js.executeScript("return document.querySelector('shop-app')"
//				+ ".shadowRoot.querySelector('iron-pages').querySelector('shop-home')"
//				+ ".shadowRoot.querySelector('div:nth-of-type(1) > shop-button > a')");
//		targetElement.click();
//	}
//}
