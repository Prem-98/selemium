package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;

public class AutoSuggestiveDD {
    public static void main(String arg[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://My Folder/Selenium/Drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();

        // Create a WebDriver object
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize(); // for mazimizing the browser
//        WebDriverManager.edgedriver().setup();
//
//        EdgeOptions edgeoptions = new EdgeOptions();
//        edgeoptions.addArguments("--remote-allow-origins=*");
//        edgeoptions.addArguments("--start-maximized");
//        edgeoptions.addArguments("--disable-notifications");
//        WebDriver driver = new EdgeDriver(edgeoptions);
//        driver.manage().window().maximize(); // for mazimizing the browser
        driver.get("https://www.google.com/");
        // here i have kept navigate even after openinig the URL because edge was throwing an notification because of that elements were not iterable to handle that i have added navigate agian .
        Thread.sleep(3000);
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); // here * before id works as regular expression whereas it searches for the given id name is matching for any id in the page
       System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options)  // here we are itrating the options one by one and storing in option as a webElement
            {
            if(option.getText().equalsIgnoreCase("India"))
            {
            System.out.println(option.getText());
            option.click();
            break;
        }else{
            System.out.println("This option is not india");
        }
    }
        driver.quit();
}
}
