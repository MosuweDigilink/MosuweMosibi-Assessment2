package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    private WebDriver driver;
    private By logoutAlert = By.linkText("Logout");

    private By cartButton = By.xpath("//span[@class = 'cart-name-and-total']");


    public DashBoardPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getLogoutText() {

        return driver.findElement(logoutAlert).getText();
    }

    public CartPage clickCartIcon() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }


}
