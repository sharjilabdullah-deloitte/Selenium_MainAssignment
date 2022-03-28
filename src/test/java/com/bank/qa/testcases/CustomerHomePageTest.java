package com.bank.qa.testcases;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.CustomerHomePage;
import com.bank.qa.pages.CustomerLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerHomePageTest extends TestBase {
    CustomerLogin customerLogin;
    CustomerHomePage customerHomePage;

    public CustomerHomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        customerLogin=new CustomerLogin();
        customerHomePage = customerLogin.login();
    }

    @Test
    public void verifyTransactionTest(){
        customerHomePage.verifyTransaction();
        WebElement checkLastTransaction= driver.findElement(By.xpath("//td[contains(text(),'233442')]"));
        int showedTransaction= Integer.parseInt(checkLastTransaction.getText());
        Assert.assertEquals(showedTransaction,233442); //Hard Coded change this ..!!
    }

    public void verifyDepositTest(){

        //customerHomePage.deposit();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
