package Generic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Addtocart {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(5000);
        String [] products={"Cucumber","Beetroot"};
        int j=0;

        List<WebElement> items=driver.findElements(By.xpath("//h4[@class='product-name']"));
        for(int i=0;i<items.size();i++){

            String [] names=items.get(i).getText().split("-");  // to remove the 1 kg text
             String formatedname=names[0].trim(); // triming the white spaces
            //conveting array to array list
            List al= Arrays.asList(products);

            if(al.contains(formatedname)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==2)
                    break;
            }
        }
        driver.quit();
}}
