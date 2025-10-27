package miniProject;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HumanResourceManagementProject {
    
    WebDriver driver;
    WebDriverWait wait;

//     ------------------ Setup -------------------
    private void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

//     ------------------ Login -------------------
    private void login(String username, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Username']")));
        userNameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        passwordField.sendKeys(password);
        driver.findElement(By.xpath("//button[text() = ' Login ']")).click();
        
        //Verify the current URL and check if it contains the string “dashboard”.
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        System.out.println("URL after login: " + driver.getCurrentUrl());
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
        System.out.println("Dashboard Text: " + dashboard.getText());
    }

//     ------------------ Navigate to Admin > Job Titles -------------------
    private void goToJobTitles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//span[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"))).click();

        WebElement jobMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Job ']")));
        jobMenu.click();

        List<WebElement> jobOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@class = 'oxd-dropdown-menu' and @role = 'menu' ]//a")));

        boolean isJobTitles = false;
        for (WebElement l : jobOptions) {
            if (l.getText().equals("Job Titles")) {
                l.click();
                isJobTitles = true;
                System.out.println("Clicked on Job Titles");
                break;
            }
        }

        if (!isJobTitles) {
            System.out.println("Job Titles is not available!");
            tearDown();
        }
    }

//     ------------------ List All Jobs -------------------
    private void listAllJobs() {
        System.out.println("-------List of All Jobs Available:");
        WebElement jobTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-table-body")));
        System.out.println(jobTable.getText());
    }

//     ------------------ Add New Job -------------------
    private void addJob(String jobTitle) throws InterruptedException {
        WebElement addButton = driver.findElement(By.xpath("//button[text() = ' Add ']"));
        addButton.click();

        WebElement inputField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")));
        inputField.sendKeys(jobTitle);

        WebElement saveButton = driver.findElement(By.xpath("//button[text() = ' Save ']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
        Thread.sleep(1000);
        saveButton.click();
        System.out.println("New Job Added: " + jobTitle);
    }

//     ------------------ Logout -------------------
    private void logout() throws InterruptedException {
        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
        System.out.println("Logged out successfully.");
    }

//     ------------------ Tear Down -------------------
    private void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//     ------------------ Main Test -------------------
    @Test
    public void hrmMiniProject() throws InterruptedException {
    	
        FileInputStream f = null;
        Properties prop = null;
        try {
        	f = new FileInputStream("C:\\Users\\2440634\\eclipse-workspace\\SELENIUMTESTING\\src\\test\\java\\miniProject\\config.properties");
        	prop = new Properties();
        	prop.load(f);
        } catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
        }
        String username = prop.getProperty("item.username");
        String password = prop.getProperty("item.password");
        String jobTitle = prop.getProperty("item.jobTitle");
        setUp();
//       login("Admin", "admin123");
        login(username, password);//
        goToJobTitles();
        listAllJobs();
//        addJob("Automation Tester");
        addJob(jobTitle);//
        logout();
        tearDown();

    }
}