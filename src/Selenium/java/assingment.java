import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assingment {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption3")).click();
        String check=driver.findElement(By.id("checkBoxOption3")).getAttribute("value").trim();
        Select dd= new Select(driver.findElement(By.id("dropdown-class-example")));
        dd.selectByValue(check);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(check);
        driver.findElement(By.id("alertbtn")).click();
        String alert=driver.switchTo().alert().getText();
        Assert.assertTrue(alert.contains(check));
        System.out.println(alert);
        driver.quit();
    }
}
