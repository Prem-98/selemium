package JavaStreams;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String arg[]) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //clicking on the coloumn
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //getting all the names in the coloumn
        List<WebElement> elements=driver.findElements(By.xpath("//tr/td[1]"));
        //collecting the text of the elements
        List<String> originalList= elements.stream().map(WebElement::getText).toList();
        //sorting the list
        List<String> sortedList= originalList.stream().sorted().toList();
        //comparing both the lists
        Assert.assertTrue(originalList.equals(sortedList));
        driver.quit();
    }
}
