package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;

public class UnsuccessfulLogin extends BaseTests {

    @Test
    public void testUnsuccessfulLogin() throws InterruptedException {
        homepage.clickDismiss();
        Thread.sleep(2000);

        MyAccountPage myAccountPage = homepage.clickMyAccount();
        Thread.sleep(2000);

        myAccountPage.enterUsername("mosuwe");
        Thread.sleep(3000);
        myAccountPage.enterPassword("Mm.46537876");
        Thread.sleep(3000);

        myAccountPage.clickLoginButton();
        Thread.sleep(2000);

        assertEquals(myAccountPage.getErrorText(), "ERROR", "No error message");


    }
}
