package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{

    // precondition
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
    }

    @Test
    public void addContactPositiveTest() {
        // click on Add link
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName("Adams")
                .setLastName("Karlson")
                .setPhone("1234567890")
                .setEmail("adams@gmail.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        // click on the Save button
        app.getContact().clickOnSaveButton();

        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText("Adam"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();

    }


    @Test(dataProvider = "addContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastname, String phone, String email, String address, String desc) {
        // click on Add link
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        // click on the Save button
        app.getContact().clickOnSaveButton();

        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText(name));

    }


    @Test(dataProvider = "addContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithFile(Contact contact) {
        // click on Add link
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(contact);
        // click on the Save button
        app.getContact().clickOnSaveButton();

        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));

    }



}
