package TestNG;

import org.testng.annotations.*;

public class TestNG {
    @Test
    public void print(){
        System.out.println("Testing TestNG");
    }

    @Test
    public void print2(){
        System.out.println("Printing testcase 2");
    }

    @Test
    public void print3(){
        System.out.println("Print 3rd time");
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

}
