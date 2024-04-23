package Miscellaneous;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HightandWidth {
    public static void main(String arg[]) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        driver.quit();
}}
