package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DropdownAssignment {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        List <WebElement> country = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
        for (WebElement option : country) {
            if(option.getText().equalsIgnoreCase("India")){
                System.out.println(option.getText());
                option.click();
            }

            Thread.sleep(4000);

        }
        driver.quit();
    }}