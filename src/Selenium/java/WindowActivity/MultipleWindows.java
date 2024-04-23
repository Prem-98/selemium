package WindowActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {  //  This multiple windows method is introduced in Selenium 4.0 version only
    public static void main(String arg[]) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parent=it.next();
        String child=it.next();
        driver.switchTo().window(child);
        driver.get("https://courses.rahulshettyacademy.com/courses/");
        String course=driver.findElements(By.xpath("//div[@class='course-listing-title']")).get(0).getText();
        driver.switchTo().window(parent);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(course);
        driver.quit();
    }
}
