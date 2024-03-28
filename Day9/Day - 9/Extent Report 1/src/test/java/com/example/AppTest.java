package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.model.ScreenCapture;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    public static Logger logger = LogManager.getLogger(AppTest.class);

    @Test
    public void runTest() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\91759\\Downloads\\Book1.xls");

        Workbook wb = new HSSFWorkbook(fis);
        Sheet sheet = wb.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        String url = row.getCell(0).getStringCellValue();
        url="https://groww.in/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement calc = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/div[1]/div[2]/div[3]/a[2]")));
        calc.click();
        WebElement top = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/h1")));
        String title = top.getText();
        if (title.equals("Calculators")) {
            logger.info("The calculator is present in the top");
            System.out.println("The calc is there");
        }
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
        WebElement homeLoan = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/a[15]/div/p[1]")));
        homeLoan.click();
        WebElement loanAmt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"LOAN_AMOUNT\"]")));
        loanAmt.sendKeys("2300000");
        logger.info("Amount updated");
        driver.findElement(By.xpath("//*[@id=\"RATE_OF_INTEREST\"]")).sendKeys("8");
        driver.findElement(By.xpath("//*[@id=\"LOAN_TENURE\"]")).sendKeys("25");
        String amtDetails = driver
                .findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if (amtDetails.equals("Your Amortization Details (Yearly/Monthly)")) {
            logger.info("The given string is found");
            System.out.println("The string is found");
        }
        wb.close();
        fis.close();
        driver.close();

    }

}