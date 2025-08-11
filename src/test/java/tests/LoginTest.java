/*
package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseAnnotation {

    @Test(description = "Verify Login Functionality With valid credentials")
    public void testValidLogin() throws InterruptedException {
        String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");
        loginPage.login(user, pass);
        logOut.SignOut();

    }

}*/
package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;
import pages.LogOut;
import utils.JsonDataReader;

public class LoginTest extends BaseAnnotation {

    @Test(description = "Verify Login Functionality with valid credentials")
    public void testValidLogin() {
        String user = JsonDataReader.getTestData().username;
        String pass = JsonDataReader.getTestData().password;

        loginPage.login(user, pass);
        logOut.SignOut();
    }
}

