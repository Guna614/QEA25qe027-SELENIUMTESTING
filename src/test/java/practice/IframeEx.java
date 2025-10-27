//package practice;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class IframeEx {
//    @Test
//    public void iframework() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://webapps.tekstac.com/PurchaseApp/");
//        
//        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframe_heading']"));
//        driver.switchTo().frame(iframe);// to iframe page its a sub html page in a bigger html page
//
//        driver.switchTo().defaultContent();//to back to first page
//
//        WebElement cq = driver.findElement(By.xpath("//input[@id = 'ComputerQuantity']"));
//        		cq.sendKeys("2");
//        WebElement checkClick = driver.findElement(By.xpath("//input[@id = 'ComputerCheck']"));
//        checkClick.click();
//        
//        driver.findElement(By.xpath("//input[@id = 'show']")).click();
//        //thank you
//        driver.findElement(By.xpath("//input[starts-with(@id, 'dur')]")).click();
//        
//        Actions a = new Actions(driver);
//        a.moveToElement(checkClick).perform();
//    }
//}