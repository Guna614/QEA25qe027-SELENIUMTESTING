//package practice;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class IframeEx2 {
//	@Test
//    public void iframework() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://training-support.net/webelements/iframes");
//        driver.manage().window().maximize();
//        
//        WebElement firstIframe = driver.findElement(By.xpath("//iframe[@class = 'mx-auto svelte-72jzmj' and @title = 'Frame1']"));
//        driver.switchTo().frame(firstIframe);
//       driver.switchTo().parentFrame(firstIframe);
//        
//        driver.findElement(By.xpath("//button[text() = 'Click me!' and @class = 'bg-purple-200 mx-4 svelte-12f6vku']")).click();
//        Thread.sleep(1000);
//        driver.switchTo().defaultContent();
//
//        WebElement secondIframe = driver.findElement(By.xpath("//iframe[@class = 'mx-auto svelte-72jzmj' and @title = 'Frame2']"));
//        driver.switchTo().frame(secondIframe);
//        
//        driver.findElement(By.xpath("//button[text() = 'Click me!' and @class = 'bg-emerald-200 mx-4 svelte-12f6vku']")).click();
//
//	}
//}
