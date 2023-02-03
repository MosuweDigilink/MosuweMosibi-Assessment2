package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    private By returnHome = By.xpath(
            "//a[@class = 'button wc-backward wp-element-button']");
    private By termsCheckBox = By.xpath("//input[@id='terms']");
    private By placeOrderButton = By.xpath("//button[@id='place_order']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickReturnHome() {
        driver.findElement(returnHome).click();
        return new HomePage(driver);
    }

    public void clickTermsCheckBox() {
        driver.findElement(termsCheckBox).click();
    }

    public OrderReceivedPage clickPaceOrderButton() {
        driver.findElement(placeOrderButton).click();
        return new OrderReceivedPage(driver);
    }
}
