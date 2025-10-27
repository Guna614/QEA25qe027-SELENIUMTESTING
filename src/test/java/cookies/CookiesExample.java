//package cookies;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CookiesExample {
//	@Test
//	public void cookiesExample() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://training-support.net/webelements");
//		Cookie cookie = new Cookie.Builder("test", "abcdefgh")//Builder(name, value)
//				.domain("training-support.net")
//				.path("/webelements")
//				.build();
//		driver.manage().addCookie(cookie); //adds a cookie
//		Thread.sleep(2000);
//		System.out.println(driver.manage().getCookieNamed("test")); // reads a cookie
//		driver.manage().getCookies();
////		driver.manage().deleteCookieNamed("test");
//	}
//}
