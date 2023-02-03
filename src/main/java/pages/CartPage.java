package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private  By myAccountLink = By.linkText("My Account");
    private By returnToShop = By.xpath("//a[@class ='button wc-backward wp-element-button']");

    private By continueShoppingLink = By.xpath("//a[normalize-space()='continue shopping']");

    public  CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage returnToHome() {
        driver.findElement(returnToShop).click();
        return new HomePage(driver);
    }

    public MyAccountPage clickMyAccount() {
        driver.findElement(myAccountLink).click();
        return new MyAccountPage(driver);
    }

    public HomePage clickContinueShopping() {
        driver.findElement(continueShoppingLink).click();
        return new HomePage(driver);
    }
}
