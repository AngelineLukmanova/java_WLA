package com.wla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Users {
    @Test
    public void AddUser(){
        WebDriver driver = new ChromeDriver();
        Login login = new Login();
        login.WLALogin(driver);
        //click button Users
        driver.findElement(By.id("ext-gen185")).click();
        //click button Actions
        driver.findElement(By.xpath("//td/table/tbody/tr/td[2]/em/button")).click();
        //select Add User menu item
        driver.findElement(By.linkText("Add User")).click();
        //enter Username, Password
        driver.findElement(By.name("Username")).sendKeys("jsmith");
        driver.findElement(By.name("Password")).sendKeys("password");
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        //click button Save
        driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //verify user was created
        WebElement body = driver.findElement(By.tagName("body"));
        boolean ret = body.getText().contains("jsmith");
        System.out.println("The user was created: " + ret);
        //logout
        driver.findElement(By.xpath("//td[4]/table/tbody/tr/td[2]/em/button")).click();
        //close the browser
        driver.close();

    }
}
