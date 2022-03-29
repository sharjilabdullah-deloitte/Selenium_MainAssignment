package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BankManagerLoginPage extends TestBase {

    WebElement addCustomerBtn,openAccountBtn;


    public BankManagerLoginPage(){
        PageFactory.initElements(driver,this);
        addCustomerBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        openAccountBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
    }

    public AddCustomer setAddCustomerBtn() throws IOException {
        addCustomerBtn.click();
        AddCustomer addCustomer = new AddCustomer();
        addCustomer.initializeCustomer();
        return addCustomer;
    }

    public OpenAccount setOpenAccountBtn(){
        openAccountBtn.click();
        OpenAccount openAccount = new OpenAccount();
        openAccount.getCustName();
        openAccount.getCurrencyOption();
        openAccount.setProcessBtn();
        return new OpenAccount();
    }
}
