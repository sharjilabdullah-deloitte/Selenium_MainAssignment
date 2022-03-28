package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    WebElement customerLoginBtn= driver.findElement(By.xpath("//button[text()='Customer Login']"));
    WebElement bankManagerLoginBtn =driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
    WebElement homeBtn= driver.findElement(By.xpath("//button[contains(text(),'Home')]"));

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    //Functions
    public CustomerLogin selectCustomerLogin(){
        customerLoginBtn.click();
        return new CustomerLogin();
    }
    public BankManagerLoginPage selectBankManagerLogin(){
        bankManagerLoginBtn.click();
        return new BankManagerLoginPage();
    }
}
