package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    //precondition
    @BeforeMethod
    public void precondition() {
        // if login link is not present
        if (!app.getUser().isLoginLinkPresent()) {
            // click on Sign Out button
            app.getUser().clickOnSignOutButton();
        }

        // click on Login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("derkach@gmail.com")
                .setPassword("Manuel1234$"));

        // click on the login button
        app.getUser().clickOnLoginButton();

        // click on Add link
        app.getContact().clickOnAddLink();

        // enter name
        app.getContact().fillContactForm(new Contact()
                .setName("Adams")
                .setLastName("Karlson")
                .setPhone("1234567890")
                .setEmail("adams@gmail.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));

        // click on the Save button
        app.getContact().clickOnSaveButton();

    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        // click on the card
        app.getContact().removeContact();

        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        // assert Contact is deleted by size
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}
