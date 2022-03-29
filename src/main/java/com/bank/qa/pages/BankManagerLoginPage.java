package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginPage extends TestBase {

    WebElement addCustomerBtn,openAccountBtn;


    public BankManagerLoginPage(){
        PageFactory.initElements(driver,this);
        addCustomerBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        openAccountBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
    }

    public AddCustomer setAddCustomerBtn(){
        addCustomerBtn.click();
        return new AddCustomer();
    }

    public OpenAccount setOpenAccountBtn(){
        openAccountBtn.click();
        return new OpenAccount();
    }
}
