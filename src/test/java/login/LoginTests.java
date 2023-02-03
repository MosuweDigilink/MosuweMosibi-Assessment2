package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
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

        //Go to cart page and add an item
        CartPage cartPage = dashBoardPage.clickCartIcon();
        Thread.sleep(2000);

        HomePage homePage = cartPage.returnToHome();
        Thread.sleep(2000);

        //Select sale item on HomePage
        SaleItemOnePage saleItemOnePage = homePage.clickSaleItemOne();
        Thread.sleep(2000);

        String colorOption = "Beige";
        //Select color of item and validate correct option is chosen
        saleItemOnePage.selectFromColorDropdown("Beige");
        Thread.sleep(2000);
        var selectedColor = saleItemOnePage.getSelectedColors();
        //confirm one color is chosen
        assertEquals(selectedColor.size(), 1, "Incorrect number of selections");
        Thread.sleep(2000);
        //confirm chosen color
        assertTrue(selectedColor.contains(colorOption),"Option not selected");
        Thread.sleep(2000);

        String sizeOption = "Large";
        //Select size of item and validate correct option is chosen
        saleItemOnePage.selectFromSizeDropdown("Large");
        Thread.sleep(2000);
        var selectedSize = saleItemOnePage.getSelectedSizes();
        //confirm one size is chosen
        assertEquals(selectedSize.size(), 1, "Incorrect number of selections");
        Thread.sleep(2000);
        //confirm chosen size
        assertTrue(selectedSize.contains(sizeOption),"Option not selected");
        Thread.sleep(2000);

        saleItemOnePage.addToCart();
        Thread.sleep(2000);

        CartPage cartPage1 = saleItemOnePage.clickCartIcon();
        Thread.sleep(2000);

        MyAccountPage myAccountPage1 = cartPage1.clickMyAccount();
        Thread.sleep(2000);

        myAccountPage1.clickLogoutButton();
        Thread.sleep(3000);


    }
}
