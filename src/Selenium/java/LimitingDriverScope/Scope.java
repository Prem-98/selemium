package LimitingDriverScope;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // 1. Finding no of links present on the website
        System.out.println(driver.findElements(By.tagName("a")).size());
        // 2.Finding links present in the footer section by scoping the limit of the webdriver
        WebElement footer=driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());
        //3. Finding no of links present in frist coloumn of the footer and opening them
        WebElement coloumn=footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
        System.out.println(coloumn.findElements(By.tagName("a")).size());

        for(int i=1;i<coloumn.findElements(By.tagName("a")).size();i++){
            String ctrlclick= Keys.chord(Keys.CONTROL,Keys.ENTER);  // this is used to perform keyboard action Ctlr+Enter
            coloumn.findElements(By.tagName("a")).get(i).sendKeys(ctrlclick);
            Thread.sleep(1000);
        }
        //opening all the windows and getting their titles
            Set<String>abc=driver.getWindowHandles();
            Iterator<String>it=abc.iterator();
            while (it.hasNext()){
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }
            driver.quit();
        }



    }


