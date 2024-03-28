package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

     public static Logger logger = LogManager.getLogger(AppTest.class);
    
    @Test
    public void test() {
        // Set Chrome driver path
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        try {
            // Test Case 1: Flight Search
            driver.get("https://www.ixigo.com/");
            File f=new File("C:\\Users\\91759\\Downloads\\Book1.xls");
            FileInputStream fr=new FileInputStream(f);
            Workbook wb=new HSSFWorkbook(fr);
            Sheet st=wb.getSheet("Sheet1");
            Row r=st.getRow(0);
            String a= r.getCell(0).getStringCellValue();
            String b=r.getCell(1).getStringCellValue();
            // Click on Round Trip
            WebElement roundTripButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]"));
            roundTripButton.click();

            // Input From city
            WebElement fromInput = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div"));
            fromInput.sendKeys(a);

            // Select From city from dropdown
            WebElement fromDropdownOption = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/li"));
            fromDropdownOption.click();

            // Input To city
            WebElement toInput = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div"));
            toInput.sendKeys(b);

            // Select To city from dropdown
            WebElement toDropdownOption = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li"));
            toDropdownOption.click();

            // Select Departure date
            WebElement departureDate = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/p[2]"));
            departureDate.sendKeys("Nov-6-2023");

            // Select Return date
            WebElement returnDate = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div/p[2]"));
            returnDate.sendKeys("Nov-8-2023");

            // Click on Travellers and Class section
            WebElement travellersClassSection = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div/div/div/div/p[2]"));
            travellersClassSection.click();

            // Increase value for Adults and Child
            WebElement adultsInput = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[3]"));
            adultsInput.click();

            WebElement childInput = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[3]"));
            childInput.click();

            // Choose Business class
            WebElement businessClassOption = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]/p"));
            businessClassOption.click();

            // Verify return date contains "08 Nov"
            if (returnDate.getAttribute("value").contains("08 Nov")) {
                System.out.println("Return date contains '08 Nov'. Test Case 1 passed.");
                logger.info("It is true");
            } else {
                System.out.println("Return date does not contain '08 Nov'. Test Case 1 failed.");
                logger.info("It is false");
            }

            // Test Case 2: Verify About Us URL
            driver.get("https://www.ixigo.com/");
            WebElement aboutUsLink = driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div[2]/div[1]/p[1]/a"));
            aboutUsLink.click();

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("about")) {
                System.out.println("Redirected URL contains 'about'. Test Case 2 passed.");
                logger.info("It is true"); 
            } else {
                System.out.println("Redirected URL does not contain 'about'. Test Case 2 failed.");
                logger.info("It is false");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } 
    }
}
