package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ShoppingPage3;

public class StupidTest extends BaseTests {

    @Test
    public void TestPage2Button() throws InterruptedException {
        homepage.clickDismiss();
        Thread.sleep(2000);
        ShoppingPage3 shoppingPage3 = homepage.scrollAndClickPageThree();
    }
}
