package com.example;

import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AppTest 
{
   @Test
   public void map() throws InterruptedException
   {
       WebDriver driver=new ChromeDriver();
       driver.navigate().to("https://economictimes.indiatimes.com/et-now/results");
       driver.manage().window().maximize();

       Thread.sleep(3000);
       driver.findElement(By.xpath("/html/body/main/div[4]/nav/div[10]/a")).click();
   
        WebElement selectElement = driver.findElement(By.id("amcSelection"));

        // Wrap the select element in a Select object
        Select select = new Select(selectElement);

        // Select by visible text
        select.selectByVisibleText("Canara Robeco");
   
        WebElement selectElement2 = driver.findElement(By.id("schemenm"));

        // Wrap the select element in a Select object
        Select select2 = new Select(selectElement2);

        // Select by visible text
        select2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
      
       driver.findElement(By.xpath("//*[@id=\"getDetails\"]")).click();

      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/span")).click();
      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]")).click();

      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/span")).click();
      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]")).click();

      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/span")).click();
      driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]")).click();

      driver.findElement(By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]")).click();

      driver.quit();

   }
}