package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTeats extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHomePage().isHomeComponentPresent()) {
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest () {
//        System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
