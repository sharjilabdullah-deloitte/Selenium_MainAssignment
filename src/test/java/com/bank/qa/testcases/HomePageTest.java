package com.bank.qa.testcases;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.AddCustomer;
import com.bank.qa.pages.BankManagerLoginPage;
import com.bank.qa.pages.CustomerLogin;
import com.bank.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePage homePage ;
    CustomerLogin customerLogin;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomer addCustomer;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        homePage=new HomePage();
        //customerLogin=new CustomerLogin();

    }

    @Test(priority = 1)

    public void selectBankManagerLoginPageTest() throws IOException {
        bankManagerLoginPage= homePage.selectBankManagerLogin();
        bankManagerLoginPage.setAddCustomerBtn();
        bankManagerLoginPage.setOpenAccountBtn();
    }

    @Test(priority = 2)
    public void selectCustomerLoginTest(){
        //CustomerLogin custLogin = new CustomerLogin();
        customerLogin = new CustomerLogin();
        customerLogin=homePage.selectCustomerLogin();
        customerLogin.selectAndFindElement();
        customerLogin.selectName();
        customerLogin.login();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
