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

        //getting the price of beans
        List<String> price=elements.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
        price.forEach(p-> System.out.println("Price of Beans is : "+p));
        //getting price of any item that is present on the webpage (to serach in all other pages)
        List<String> cost;
        do{
            List<WebElement> items=driver.findElements(By.xpath("//tr/td[1]"));
            cost=items.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
            cost.forEach(p-> System.out.println("Price of item is: "+p));
            if(cost.size()<1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        }while (cost.size()<1);


        driver.quit();
    }

    private static String getPrice(WebElement a) {
        String price=a.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}
