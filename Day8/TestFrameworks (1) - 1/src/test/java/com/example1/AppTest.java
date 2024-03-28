package com.example1;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void tesing() throws Exception
    {
        File file = new File("Keywords.xls");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(fis);
        Sheet sh = wb.getSheet("Sheet1");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int rc = sh.getLastRowNum() - sh.getFirstRowNum();
        for(int i=0;i<rc;i++){
            Row r = sh.getRow(i);
            if(r.getCell(0).getStringCellValue().equals("openurl")){
                driver.get("https://www.google.com");
                driver.manage().window().maximize();
                Thread.sleep(3000);
            }
            else if(r.getCell(0).getStringCellValue().equals("gettitle")){
                driver.get("https://www.google.com");
                String p = driver.getTitle();
                Thread.sleep(3000);
                System.out.println(p);
            }
        }
        wb.close();
        driver.quit();
    }
}
