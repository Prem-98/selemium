package Scrolling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class scrollAssignment {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List <WebElement> rows=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        System.out.println("No.of Rows- "+rows.size());
        List <WebElement> columns=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
        System.out.println("No.of Cloumns- "+columns.size());
        List <WebElement> text=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
        for(int i=0;i< text.size();i++){
            System.out.println(text.get(i).getText());
        }
        driver.quit();
    }
}
