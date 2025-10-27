//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//public class goibiboExample {
//    public static void main(String[] args) {
//    	
//        
////        ChromeOptions option = new ChromeOptions();
////        option.addArguments("--disable-notifications");
//    	WebDriver driver = new EdgeDriver(); 
//
//
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        
////        driver.get("https://www.goibibo.com/");
//        driver.get("https://www.goibibo.com/");
//        driver.findElement(By.xpath("//span[@class = 'logSprite icClose']")).click();
//      //p[@class ='sc-jlwm9r-1 ewETUe']
//        driver.findElement(By.xpath("//p[@class ='sc-jlwm9r-1 ewETUe']")).click();
//        
//        driver.findElement(By.xpath("//span[text() = 'From']")).click();
//        WebElement fromBox = wait.until(ExpectedConditions
//                .presenceOfElementLocated(By.xpath("//input[@type = 'text']")));
//        fromBox.sendKeys("hydrabad");
//
//        List<WebElement> options = wait.until(ExpectedConditions
//                .presenceOfAllElementsLocatedBy(By.xpath("//ul[@id = 'autoSuggest-list']/li")));
//
//        System.out.println("from optinons ------------------------:");
//        for (WebElement opt : options) {
//            System.out.println(opt.getText());
//        }
//        	//ul[@id = 'autoSuggest-list']/li[1]
//        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id = 'autoSuggest-list']/li[1]")));
//        select.click();
//        
//        
//        //to field clicking
//        
//          driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("bengaluru");
//         
//          List<WebElement> optionsto = wait.until(ExpectedConditions
//                  .presenceOfAllElementsLocatedBy(By.xpath("//ul[@id = 'autoSuggest-list']/li")));
//          
//          System.out.println("To options locations --------:");
//          for (WebElement opt : optionsto) {
//              System.out.println(opt.getText());
//          }
//
//          WebElement select2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id = 'autoSuggest-list']/li[1]")));
//          select2.click();
//          
//        //span[text() = 'SEARCH FLIGHTS']
//          driver.findElement(By.xpath("//p[text() = 'One-way']")).click();
//          driver.findElement(By.xpath("//span[@class = 'sc-12foipm-72 ezNmSh' and text() = 'SEARCH FLIGHTS']")).click();
//          
//    }
//}