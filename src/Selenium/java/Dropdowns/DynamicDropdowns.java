package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DynamicDropdowns {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeoptions);
        driver.manage().window().maximize(); // for mazimizing the browser
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='IXG']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // parent child xpath
    }
}
