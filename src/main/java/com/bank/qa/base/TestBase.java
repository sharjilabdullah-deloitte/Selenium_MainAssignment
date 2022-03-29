package com.bank.qa.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//This will use the concept of INHERITANCE
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\asharjil\\IdeaProjects\\HU_Selenium_Track\\MainAsgnmnt\\src\\main\\java\\com\\" +
                    "bank\\qa\\config\\config.properties ");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        else{
            System.out.println("Its other than chrome");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));

    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    }


