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

    WebElement depositAmountBtn=driver.findElement(By.xpath("//button[text()='Deposit']"));
    WebElement withdrawalAmountBtn=driver.findElement(By.xpath("//button[text()='Withdraw']"));

    public static int prevBalance= Integer.parseInt(driver.findElement(By.xpath("//*[normalize-space()='Dollar']/preceding-sibling::*[1]")).getText());
    public static int depositAmount = 0;
    public static int updatedAmount=0;
    public static int withDrawalAmount= 0;
    public static int withDrawalAmount1=0;
    public static int depositAmount1=0;


    public CustomerHomePage(){
        PageFactory.initElements(driver,this);
    }



    public int deposit() throws IOException {
        depositBtn.click();
        String excelFilePath = ".\\src\\main\\java\\com\\bank\\qa\\testdata\\MainSele_Depo_Withdraw.xlsx"; //Locating Excell File path
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0) ;//For Deposit
        depositAmount = (int) cell.getNumericCellValue();


        System.out.println("***READING DEPOSIT DATA FROM EXCEEL SHEET");
        driver.findElement(By.xpath("//input[@type='number'] ")).sendKeys(String.valueOf(depositAmount));
        depositAmountBtn.click();
        return depositAmount;
    }

    public int getUpdatedAmount(){
        updatedAmount=depositAmount + prevBalance;
        return updatedAmount;
    }

    public int withdrawal() throws IOException {
        withdrawalBtn.click();
        String excelFilePath = ".\\src\\main\\java\\com\\bank\\qa\\testdata\\MainSele_Depo_Withdraw.xlsx"; //Locating Excell File path
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(1) ;//For Withdrawal
        withDrawalAmount = (int) cell.getNumericCellValue();

        System.out.println("***READING WITHDRAWAL DATA FROM EXCEL SHEET");
        driver.findElement(By.xpath("//input[@type='number'] ")).sendKeys(String.valueOf(withDrawalAmount));
        withdrawalAmountBtn.click();
        return withDrawalAmount;
    }

    public String negativeWithdrawal() throws IOException {
        withdrawalBtn.click();
        String excelFilePath = ".\\src\\main\\java\\com\\bank\\qa\\testdata\\MainSele_Depo_Withdraw.xlsx"; //Locating Excell File path
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(1) ;//For Withdrawal
        XSSFCell cell1 = row.getCell(0); //For Column
        withDrawalAmount1 = (int) cell.getNumericCellValue();
        depositAmount1 = (int) cell1.getNumericCellValue();

        System.out.println("***READING WITHDRAWAL DATA FROM EXCEL SHEET");
        driver.findElement(By.xpath("//input[@type='number'] ")).sendKeys(String.valueOf(withDrawalAmount1));
        withdrawalAmountBtn.click();
        String msg= driver.findElement((By.xpath("//span[contains(text(),'Transaction Failed. You can not withdraw amount mo')]"))).getText();
        return msg;
    }

}
