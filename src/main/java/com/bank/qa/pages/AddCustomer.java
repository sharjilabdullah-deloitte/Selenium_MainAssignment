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

public class AddCustomer extends TestBase {

    WebElement firstName,lastName,zip,addCustomerBtn;

    public AddCustomer(){
        PageFactory.initElements(driver,this);
        firstName = driver.findElement(By.xpath("//input[@ng-model='fName']"));
        lastName = driver.findElement(By.xpath("//input[@ng-model='lName']"));
        zip = driver.findElement(By.xpath("//input[@ng-model='postCd']"));
        addCustomerBtn = driver.findElement(By.xpath("//button[@type ='submit']"));
    }

    public void initializeCustomer() throws IOException {
        String excelFilePath = ".\\src\\main\\java\\com\\bank\\qa\\testdata\\AddCustData.xlsx"; //Locating Excell File path
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0) ; // First name
        XSSFCell cell1 = row.getCell(1) ; // Last Name
        XSSFCell cell2 = row.getCell(2) ; // Zip code
        String fname=cell.getStringCellValue();
        String lname=cell1.getStringCellValue();
        int pin = (int)cell2.getNumericCellValue();

        System.out.println("***READING DEPOSIT DATA FROM EXCEEL SHEET");
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        zip.sendKeys(String.valueOf(pin));
        addCustomerBtn.click();
        driver.switchTo().alert().accept();
    }


}
