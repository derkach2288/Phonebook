package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{

    @Test
    public void createExistedAccountNegativeTest() {

        // click on Login link
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //enter email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("derkach@gmail.com");

        //enter password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Manuel1234$");

        //click on the Registration button
        driver.findElement(By.name("registration")).click();

        //assert Sign Out button is present
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
        Assert.assertTrue(isAlertAppears());
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }
}
