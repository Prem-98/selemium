package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okayBtn"))));
      driver.findElement(By.id("okayBtn")).click();
        WebElement d=driver.findElement(By.xpath("//select[@data-style='btn-info']"));
        Select DD=new Select(d);
        DD.selectByValue("consult");
        driver.findElement(By.id("signInBtn")).click();

        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("navbar-brand"))));
        int add=driver.findElements(By.xpath("//button[@class='btn btn-info']")).size();
        for(int i=1;i<=add;i++){
            driver.findElement(By.xpath("(//button[@class='btn btn-info'])["+i+"]")).click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.quit();
    }
}
