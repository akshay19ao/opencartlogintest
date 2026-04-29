package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass_crossbrowser;

public class TC_006_LoginTest_crossbrowser extends BaseClass_crossbrowser {

    @Test
    public void verify_login() {

        logger.info("Starting Login Test");

        try {
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(getDriver());

            boolean status = macc.isMyAccountPageExists();
            Assert.assertTrue(status, "Login failed");

        } catch (Exception e) {
            e.printStackTrace();   // IMPORTANT for debugging
            Assert.fail();
        }

        logger.info("Finished Login Test");
    }
}