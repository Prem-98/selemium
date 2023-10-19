package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class staticDropdowns {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeoptions);
        driver.manage().window().maximize(); // for mazimizing the browser
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement currency=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        Static Dropdowns - static dropdowns have select tag in the html code
        Select dropdown=new Select(currency);
        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(5000);
        for(int i=1;i<5;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
