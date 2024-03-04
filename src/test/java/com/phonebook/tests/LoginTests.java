package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void  unsurePrecondition() {
        // if login link is not present
        if (!app.getUser().isLoginLinkPresent()) {
            // click on Sign Out button
            app.getUser().clickOnSignOutButton();
        }
    }


    // click on Login link
    @Test(priority = 1)
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("derkach@gmail.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();

        // assert Sign Out
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
    @Test(priority = 2)
    public void loginNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();

        // assert Sign Out
        Assert.assertTrue(app.getUser().isAlertAppears());

    }


}
