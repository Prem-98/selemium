package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class Assingment {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parent=it.next();
        String child=it.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
    }
}
