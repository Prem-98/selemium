package Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assingmentframes {
    public static void main(String arg[]) throws InterruptedException {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new ChromeDriver();
    ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        System.out.println(driver.findElements(By.tagName("frameset")).size());
        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.quit();
}
}
