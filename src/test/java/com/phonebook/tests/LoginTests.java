package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void  unsurePrecondition() {
        // if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            // click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }


    // click on Login link
    @Test
    public void loginPositiveTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "derkach@gmail.com");

        //enter password
        type(By.name("password"), "Manuel1234$");

        // click on the login button
        click(By.name("login"));

        // assert Sign Out
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }



}
