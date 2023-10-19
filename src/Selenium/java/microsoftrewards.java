import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



class microsoftrewards {
    public static void main(String args[]) throws InterruptedException
    {
//        System.setProperty("webdriver.edge.driver","C:\\My Folder\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeoptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        driver.get("https://www.bing.com/");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'prem')]"))));
        driver.findElement(By.id("sb_form_q")).sendKeys("philips");
        driver.findElement(By.id("search_icon")).click();
        for(int i=1;i<=40;i++)
        {	driver.findElement(By.id("sb_form_q")).clear();
            driver.findElement(By.id("sb_form_q")).sendKeys("philips "+i);
            driver.findElement(By.id("sb_form_go")).click();

        }
    }
}
