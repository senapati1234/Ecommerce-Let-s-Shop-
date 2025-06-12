package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;

import utils.ConfigReader;

public class LoginTest extends BaseAnnotation {

    @Test
    public void testValidLogin() throws InterruptedException {
        String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");
        loginPage.login(user, pass);

    }
}
