package com.wla;

import com.dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Users {
    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    public void AddUser(String branchName, String branchAdmin, String branchPassword, String user, String password, String errorMessage){
        WebDriver driver = new ChromeDriver();
        Login login = new Login();
        login.WLALogin(driver, branchName, branchAdmin, branchPassword);
        //click button Users
        driver.findElement(By.id("ext-gen185")).click();
        //click button Actions
        driver.findElement(By.xpath("//td/table/tbody/tr/td[2]/em/button")).click();
        //select Add User menu item
        driver.findElement(By.linkText("Add User")).click();
        //enter Username, Password
        driver.findElement(By.name("Username")).sendKeys(user);
        driver.findElement(By.name("Password")).sendKeys(password);
        try{
            Thread.sleep(3000);
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

        if(!errorMessage.equals("")){
            //verify the correct error message appears
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(errorMessage);
            System.out.println("The error message is correct: " + ret);
            //click OK button
            driver.findElement(By.xpath("//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")).click();
            //click Cancel button
            driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]")).click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }


        } else {
            //verify user was created
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(user);
            System.out.println("The user was created: " + ret);

        }

        //logout
        driver.findElement(By.xpath("//td[4]/table/tbody/tr/td[2]/em/button")).click();
        //close the browser
        driver.close();

    }
}
