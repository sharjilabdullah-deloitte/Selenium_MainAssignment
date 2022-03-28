package com.bank.qa.testcases;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.BankManagerLoginPage;
import com.bank.qa.pages.CustomerLogin;
import com.bank.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage ;
    CustomerLogin customerLogin;
    BankManagerLoginPage bankManagerLoginPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage=new HomePage();
        customerLogin=new CustomerLogin();
        bankManagerLoginPage= new BankManagerLoginPage();
    }

    @Test(priority = 1)
    public void selectCustomerLoginTest(){
        customerLogin=homePage.selectCustomerLogin();
    }

    @Test(priority = 2)
    public void selectBankManagerLoginPageTest(){
        bankManagerLoginPage= homePage.selectBankManagerLogin();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}