package Miscellaneous;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Screenshot {
    public static void main(String arg[]) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
       WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.co.in/");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\premk\\IdeaProjects\\mvn2\\Screenshot\\TestSS.png"));
//        driver.quit();

     // This is taking partial screenshot of the Web Element .This feature is introduced in selenium 4.0 version
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
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(course);
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));


    }
}
