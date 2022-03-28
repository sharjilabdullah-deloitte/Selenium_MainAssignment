package com.bank.qa.testcases;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.CustomerHomePage;
import com.bank.qa.pages.CustomerLogin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginTest extends TestBase {
    CustomerLogin customerLogin;
    CustomerHomePage customerHomePage;

    public CustomerLoginTest(){
        super();    // For Initializing Properties
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        customerLogin=new CustomerLogin();
        customerHomePage=new CustomerHomePage();
    }

    @Test(priority = 1)
    public void selectNameTest(){
       String n=  customerLogin.selectName();
        Assert.assertEquals(n,"Harry Potter");
    }

    @Test(priority = 2)
    public void customerHomePageTest(){
        customerHomePage= customerLogin.login();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
