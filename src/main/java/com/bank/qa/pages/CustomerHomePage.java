package com.bank.qa.pages;

import com.bank.qa.base.TestBase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class CustomerHomePage extends TestBase  {

    WebElement transactionsBtn = driver.findElement(By.xpath("button[ng-class='btnClass1']"));
    WebElement depositBtn = driver.findElement(By.xpath("button[ng-class='btnClass2']"));
    WebElement withdrawalBtn = driver.findElement(By.xpath("button[ng-class='btnClass3']"));

    public CustomerHomePage(){
        PageFactory.initElements(driver,this);
    }

    public TransactionPage verifyTransaction(){
        transactionsBtn.click();
        return new TransactionPage();
    }

    public void deposit() throws IOException {
        depositBtn.click();
        String excelFilePath = ".\\src\\main\\java\\com\\bank\\qa\\testdata\\MainSele_Depo_Withdraw.xlsx"; //Locating Excell File path
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0) ;//For Deposit
        int depositAmount = 0;
        depositAmount = (int) cell.getNumericCellValue();

        System.out.println("***READING DEPOSIT DATA FROM EXCEEL SHEET");

        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
    }

    public WithdrawalPage withdrawal(){
        withdrawalBtn.click();
        return new WithdrawalPage();
    }
}
