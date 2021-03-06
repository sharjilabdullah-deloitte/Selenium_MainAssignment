package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount extends TestBase {

    Select custName;
    Select currencyOption;
    WebElement processBtn;

    public OpenAccount(){
        PageFactory.initElements(driver,this);
        custName= new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        currencyOption = new Select(driver.findElement(By.xpath("//select[@id='currency']")));
        processBtn = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
    }
    public Select getCustName() {
        custName.selectByVisibleText("Abdullah Sharjil");
        return custName;
    }

    public Select getCurrencyOption() {
        currencyOption.selectByValue("Rupee");
        return currencyOption;
    }

    public void setProcessBtn() {
        processBtn.click();
        driver.switchTo().alert().accept();
    }
}
