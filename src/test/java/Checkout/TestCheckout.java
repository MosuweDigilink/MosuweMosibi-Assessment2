package Checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCheckout extends BaseTests {

    @Test
    public void testCheckOut() throws InterruptedException {
        homepage.clickDismiss();
        Thread.sleep(2000);

        MyAccountPage myAccountPage = homepage.clickMyAccount();
        Thread.sleep(2000);

        myAccountPage.enterUsername("moose");
        Thread.sleep(2000);
        myAccountPage.enterPassword("Mm.46537876");
        Thread.sleep(2000);

        DashBoardPage dashBoardPage = myAccountPage.clickLoginButton();

        //Validate login
        assertEquals(dashBoardPage.getLogoutText(),
                "Logout","Alert text incorrect");

        //Go to cart page and add additional item on page 3
        CartPage cartPage = dashBoardPage.clickCartIcon();
        Thread.sleep(2000);

        HomePage homePage = cartPage.clickContinueShopping();
        Thread.sleep(6000);


        ShoppingPage3 shoppingPage3 = homePage.scrollAndClickPageThree();
        Thread.sleep(2000);

        ItemTwoPage itemTwoPage = shoppingPage3.clickItemTwoLink();
        Thread.sleep(2000);

        String colorOption = "Orange";
        //Select color of item and validate correct option is chosen
        itemTwoPage.selectFromColorDropdown(colorOption);
        Thread.sleep(2000);
        var selectedColor = itemTwoPage.getSelectedColors();
        //confirm one color is chosen
        assertEquals(selectedColor.size(), 1, "Incorrect number of selections");
        Thread.sleep(2000);
        //confirm chosen color
        assertTrue(selectedColor.contains(colorOption),"Option not selected");
        Thread.sleep(2000);

        String sizeOption = "Large";
        //Select size of item and validate correct option is chosen
        itemTwoPage.selectFromSizeDropdown("Large");
        Thread.sleep(2000);
        var selectedSize = itemTwoPage.getSelectedSizes();
        //confirm one size is chosen
        assertEquals(selectedSize.size(), 1, "Incorrect number of selections");
        Thread.sleep(2000);
        //confirm chosen size
        assertTrue(selectedSize.contains(sizeOption),"Option not selected");
        Thread.sleep(2000);

        itemTwoPage.addToCart();
        Thread.sleep(2000);

        CheckoutPage checkoutPage = itemTwoPage.clickCheckoutLink();
        Thread.sleep(2000);

        checkoutPage.clickTermsCheckBox();
        Thread.sleep(2000);

        OrderReceivedPage orderReceivedPage = checkoutPage.clickPaceOrderButton();
        Thread.sleep(5000);
    }
}
