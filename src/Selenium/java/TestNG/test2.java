package TestNG;

import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class test2 {
    @Test
    public void webLogin(){
        System.out.println("webpage login");
    }
    @Test
    public void webSignout(){
        System.out.println("Webpage logout");
    }
    @Test(groups = {"Loan"})
    public void goldLoan(){
        System.out.println("This is gold loan related ");
    }
}
