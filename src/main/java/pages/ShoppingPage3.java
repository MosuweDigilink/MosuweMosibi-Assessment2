package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage3 {

    WebDriver driver;

    private By itemTwoLink = By.xpath("//img[@class ='product-one-thumb']");

    public ShoppingPage3(WebDriver driver) {
        this.driver = driver;
    }

    public ItemTwoPage clickItemTwoLink() {
        driver.findElement(itemTwoLink).click();
        return new ItemTwoPage(driver);
    }
}
