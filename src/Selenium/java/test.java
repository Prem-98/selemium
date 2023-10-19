import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) throws Exception {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\premk\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        // firefox launch
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\premk\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        // Microsoft edge
//        System.setProperty("webdriver.edge.driver","C:\\My Folder\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
//        WebDriver driver = new EdgeDriver();

        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--remote-allow-origins=*");
        edgeoptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeoptions);



        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Date curretdate=new Date();
        String ssdate=curretdate.toString().replace(" ","-").replace(":","-");
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File(".//Screenshot//"+ssdate+".png"));
        
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        String q=driver.findElement(By.xpath("//h3[@class='strong'][2]")).getText();
//        String s=driver.findElement(By.xpath("//p[2]")).getText();
//        System.out.println(q);
//        HashMap<String,String> map=new HashMap<String,String>();
//        map.put(q,s);
//        map.put("hello","prem");
////        System.out.println(map.get(q));
//        for(Map.Entry m : map.entrySet()){
//         System.out.println(m.getKey());
//        }


//        System.out.println(map.get(q));}else {System.out.println("text mismatch");}
        driver.close();
//        javaconcepts d=new javaconcepts();
//        d.getdata();
    }
//    public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{
//
//        //Convert web driver object to TakeScreenshot
//
//        TakesScreenshot scrShot =((TakesScreenshot)driver);
//
//        //Call getScreenshotAs method to create image file
//
//        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//        //Move image file to new destination
//
//        File DestFile=new File(fileWithPath);
//
//        //Copy file at destination
//
//        FileUtils.copyFile(SrcFile, DestFile);}
//    public static void TakeScreenshot(String FileName,WebDriver driver)
//            throws IOException
//    {
//        // Creating instance of File
//        File File = ((TakesScreenshot)driver)
//                .getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(File,
//                new File("\"C:\\Users\\premk\\Downloads"
//                        + FileName + ".jpeg"));
//    }
}
