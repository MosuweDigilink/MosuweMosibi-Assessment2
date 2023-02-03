package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By dismissLink = By.xpath(
            "//a[@class ='woocommerce-store-notice__dismiss-link']");
    private By myAccountLink = By.linkText("My Account");
    private By saleItem1 = By.xpath("//img[@class = 'product-one-thumb']");

    private By checkoutButton = By.linkText("Checkout");

    private By page3Link = By.linkText("3");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Click dismiss alert
    public void clickDismiss() {
        driver.findElement(dismissLink).click();
    }


    //Click My Account
    public MyAccountPage clickMyAccount() {
        driver.findElement(myAccountLink).click();
        return new MyAccountPage(driver);
    }

    public SaleItemOnePage clickSaleItemOne() {
        driver.findElement(saleItem1).click();
        return new SaleItemOnePage(driver);
    }

    public CheckoutPage clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }

    public ShoppingPage3 clickPage3Button() {
        WebElement pageThreeElement = driver.findElement(page3Link);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, pageThreeElement);
        pageThreeElement.click();
        return new ShoppingPage3(driver);
    }

    public ShoppingPage3 scrollAndClickPageThree() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("javascript:window.scrollBy(950,1200)");
        Thread.sleep(3000);
        driver.findElement(page3Link).click();
        return new ShoppingPage3(driver);
    }
}
