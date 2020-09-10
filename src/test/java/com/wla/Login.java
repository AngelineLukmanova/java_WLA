package com.wla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    @Test
    public void WLALogin(WebDriver driver, String branchName, String branchAdmin, String branchPassword){
        //open a new WLA page
        driver.get("https://www.qa-hitekschool.com/lms/loans/2108");
        //read the title of the page and output it into results
        System.out.println("Page title is: " + driver.getTitle());
        //enter branch, username, password
        driver.findElement(By.name("j_branch")).sendKeys(branchName);
        driver.findElement(By.name("j_username")).sendKeys(branchAdmin);
        driver.findElement(By.name("j_password")).sendKeys(branchPassword);
        //click button login
        driver.findElement(By.id("ext-gen38")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branchName +"' branch");

    }
}