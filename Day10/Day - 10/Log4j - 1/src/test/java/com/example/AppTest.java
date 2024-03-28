package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        String path1 = "https://www.moneycontrol.com/";

        //opening
        driver.get(path1);
        Thread.sleep(10000);

        // System.out.println("Search_Strt");
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries.",Keys.ENTER);
        
        
        // Inner of reliance Industries
        driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[4]/td[1]/p/a/strong")).click();
        Thread.sleep(2000);
        
        driver.navigate().to("https://www.moneycontrol.com/mf/sipcalculator.php");
        Thread.sleep(2000);

        // dropdown box ---1
        driver.findElement(By.xpath("//*[@id=\"ff_id\"]/option[3]")).click();
        Thread.sleep(2000);
        // dropdown box ---2
        driver.findElement(By.xpath("//*[@id=\"im_id\"]/option[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("invamt")).sendKeys("100000");
        Thread.sleep(2000);

         //strt date
         driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
         Thread.sleep(1000);
         
         //end date // clicking button
         driver.findElement(By.id("endt")).sendKeys("2023-08-17",Keys.ENTER);
         Thread.sleep(1000);
         
         String dt = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
         String amt = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
         
         System.out.println(dt);
         System.out.println(amt);
         // driver.quit();

    }
}
