package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CustomerLogin extends TestBase {

    Select name = new Select(driver.findElement(By.id("userSelect")));


    WebElement LoginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

    //Initializing Page Objects
    public CustomerLogin(){
        PageFactory.initElements(driver,this);
    }

    //Functions :
    public String selectName(){
        name.selectByValue("2");
        WebElement e =name.getFirstSelectedOption();
        String naam=e.getText();
        return naam;
    }
    public CustomerHomePage login(){
        LoginButton.click();
        return new CustomerHomePage();
    }

}
