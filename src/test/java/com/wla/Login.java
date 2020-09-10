package com.wla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    @Test
    public void WLALogin(){
        WebDriver driver = new ChromeDriver();
        //open a new WLA page
        driver.get("https://www.qa-hitekschool.com/lms/loans/2108");
        //read the title of the page and output it into results
        System.out.println("Page title is: " + driver.getTitle());
        //enter branch, username, password
        driver.findElement(By.name("j_branch")).sendKeys("Auburn");
        driver.findElement(By.name("j_username")).sendKeys("admin");
        driver.findElement(By.name("j_password")).sendKeys("alukmanova1209");
        //click button login
        driver.findElement(By.id("ext-gen38")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - 'Auburn' branch");

    }
}