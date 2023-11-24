package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class AllUI {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeoptions);
        driver.manage().window().maximize(); // for mazimizing the browser

    driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser

driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

driver.findElement(By.xpath("//a[@value='DEL']")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(5000);
//driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();

if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

    {

        System.out.println("its disabled");

        Assert.assertTrue(true);

    }

else

    {

        Assert.assertTrue(false);

    }

driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

driver.findElement(By.id("divpaxinfo")).click();

   Thread.sleep(2000L);

for(int i=1;i<5;i++)

    {

        driver.findElement(By.id("hrefIncAdt")).click();

    }

driver.findElement(By.id("btnclosepaxoption")).click();

Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

driver.findElement(By.cssSelector("input[value='Search']")).click();


}



}



