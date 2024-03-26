package Miscellaneous;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHTTPScerts {
        public static void main(String arg[]) throws InterruptedException {
            WebDriverManager.edgedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.setAcceptInsecureCerts(true);  // here we are using this chromeoptions to bypass the security process of local webpages which are not http
            WebDriver driver = new ChromeDriver(options);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://expired.badssl.com/");
            System.out.println(driver.getTitle());
        }

}
