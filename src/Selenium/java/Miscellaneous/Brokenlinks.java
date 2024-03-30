package Miscellaneous;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Brokenlinks {
    public static void main(String arg[]) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link:links){
            String url=link.getAttribute("href");
            HttpURLConnection con= (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int code=con.getResponseCode();
            System.out.println(code);
            if(code>400){
                System.out.println("The Link with name "+link.getText()+" is broken with status code "+code);
                Assert.assertTrue(false);
            }
        }
    }
}
