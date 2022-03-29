package com.bank.qa.testcases;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.CustomerHomePage;
import com.bank.qa.pages.CustomerLogin;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerHomePageTest extends TestBase {
    CustomerLogin customerLogin;
    CustomerHomePage customerHomePage;

    int bfrWithdrawal=0;

    public CustomerHomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        customerLogin=new CustomerLogin();
        customerHomePage = customerLogin.login();
    }

    /*
    @Test(priority = 1)
    public void verifyTransactionTest(){
        customerHomePage.verifyTransaction();
        WebElement checkLastTransaction= driver.findElement(By.xpath("//td[contains(text(),'233442')]"));
        int showedTransaction= Integer.parseInt(checkLastTransaction.getText());
        Assert.assertEquals(showedTransaction,233442); //Hard Coded change this ..!!
    }

     */

    @Test (priority = 1)
    public void verifyUpdatedAmount() throws IOException {

        int prvblnc=CustomerHomePage.prevBalance;
        customerHomePage.deposit();
        int updatedBlnc=customerHomePage.getUpdatedAmount();
        int dpamnt= updatedBlnc-prvblnc;
        Assert.assertEquals(CustomerHomePage.depositAmount,dpamnt);
    }

    @Test (priority = 2)
    public void verifyWithdrawalAmount() throws IOException {
        bfrWithdrawal= Integer.parseInt(driver.findElement(By.xpath("//*[normalize-space()='Dollar']/preceding-sibling::*[1]")).getText());
        customerHomePage.withdrawal();
        int aftrWithdrawal = customerHomePage.withdrawal();
        int remaining = bfrWithdrawal-aftrWithdrawal;
        Assert.assertEquals(remaining, CustomerHomePage.withDrawalAmount);
    }

    @Test (priority = 3)
    public void negativeWithdrawal() throws IOException {
        customerHomePage.negativeWithdrawal();
        System.out.println("Negative Expression");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
