package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void testing() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spencers.in/");
        Thread.sleep(3000);
        File file = new File("Book1.xls");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(fis);
        Sheet sh = wb.getSheet("Sheet1");
        Row r = sh.getRow(0);
        String x = r.getCell(0).getStringCellValue();
        Thread.sleep(3000);
        WebElement el = driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[3]"));
        el.click();
        Thread.sleep(3000);
        WebElement el2 = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        el2.sendKeys(x);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/form/ul/li[6]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"addtocart-149448\"]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[4]/div/div/div/div/div[1]/div/div/span/span[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ui-id-20\"]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/form/ul/li[2]/span")).click();
        Thread.sleep(3000);
        String k = driver.findElement(By.xpath("//*[@id=\"am-shopby-container\"]/ol/li[1]/div")).getText();
        if(k.contains("Edible Oil"))
        System.out.println("Present");
        else
        System.out.println("Not Present");
        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[3]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[3]/div[1]/div[2]/div/div[2]/div[5]/div/div/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testing@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Example20@");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"bnt-social-login-authentication\"]")).click();
        Thread.sleep(5000);
        try{
            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String filePath="D:\\Software Testing\\Projects\\test_frame_2_1\\image\\test.png";
            // Files.copy(screenShotFile.toPath(), new File(filePath).toPath());
            // Files.copy(screenShotFile.toPath(), new File(filePath).toPath());
            Files.copy(screenShotFile, new File(filePath));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
