package TestNG;

import org.apache.hc.core5.util.Timeout;
import org.testng.annotations.*;

public class TestNG {
    @Test(enabled = false)  //this method will be skipped while executing
    public void print(){
        System.out.println("Testing TestNG");
    }

    @Test(timeOut=4000) // this method will wait till 4000 milisec before failing
    public void print2(){
        System.out.println("Printing testcase 2");
    }

    @Test(dependsOnMethods = {"zprem"})   //here we are holding this method till the zprem method is executed.Even though the method execution will be done in alphabetical order but this helper atribute will hold this method
    public void print3(){
        System.out.println("Print 3rd time");
    }

    @Test
    public void zprem(){
        System.out.println("The course name is selenium");
    }

    @Parameters({"URL"})
    @Test
    public void apiLogin(String url){
        System.out.println("API Login");
        System.out.println(url);

    }
    @Parameters({"OTP","username"})
    @Test
    public void apiotp(String otp,String username){
        System.out.println("otp is "+otp);
        System.out.println("user name is "+username);
    }
    @Test(groups = {"Loan"})
    public void loan(){
        System.out.println("this the loan page");
    }
    @Test(groups = {"Loan"})
    public void creditLoan(){
        System.out.println("This is credit card loan");
    }

    @BeforeTest
    public void start(){
        System.out.println("I will run it before starting the test");
    }
    @AfterTest
    public void clear(){
        System.out.println("I will run this at the end of the test");
    }

    @BeforeSuite
    public void bfsuite(){
        System.out.println("I will execute before all the classes");
    }
    @AfterSuite
    public void afsuite(){
        System.out.println("I will execute at the end of all classes");
    }
    @BeforeMethod
    public void bmethod(){
        System.out.println("I will execute before every test method");
    }
    @AfterMethod
    public void amethod(){
        System.out.println("I will execute after every test method");}
    @BeforeClass
    public void befoclass(){
        System.out.println("This will be executed before the methods in this class and this is class specific");
    }
    @AfterClass
    public void afClass(){
        System.out.println("This will be executed After the methods in this class and this is class specific");
    }

}
