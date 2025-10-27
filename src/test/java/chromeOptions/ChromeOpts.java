//package chromeOptions;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class ChromeOpts {
//    @Test
//    public void setAcceptInsecureCerts() {
//        ChromeOptions options = new ChromeOptions();
//        // options.setAcceptInsecureCerts(true);
////        options.addArguments("--incognito");
//        options.addArguments("--disable-notifications");
//        WebDriver driver = new ChromeDriver(options); // Pass options here
//        driver.get("https://expired.badssl.com/");
//        System.out.println(driver.getTitle());
//    }
//}