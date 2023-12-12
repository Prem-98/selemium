package Asserstion;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class assertion {
    public static void main(String arg[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://My Folder/Selenium/Drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();

        // Create a WebDriver object
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize(); // for mazimizing the browser
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.9'");
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(5000);
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //The above method expects flase in the given condition so it will fail if the condition is true
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click(); // here * before id works as regular expression whereas it searches for the given id name is matching with any id in the page
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);
        driver.quit();
         }
}
