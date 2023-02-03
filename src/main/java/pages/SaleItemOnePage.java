package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class SaleItemOnePage {

    private WebDriver driver;
    private By colorDropDown = By.id("pa_color");
    private By sizeDropdown = By.id("pa_size");

    private By addToCartButton = By.xpath("//button[normalize-space() = 'Add to cart']");

    private By cartButton = By.xpath("//span[@class = 'cart-name-and-total']");

    public SaleItemOnePage(WebDriver driver) {
        this.driver = driver;
    }

    //Color Dropdown actions

    private Select findColorElement() {
        return new Select(driver.findElement(colorDropDown));
    }
    public void selectFromColorDropdown(String option) {
        findColorElement().selectByVisibleText(option);
    }

    public List <String> getSelectedColors() {
        List <WebElement> selectedColorElement =
            findColorElement().getAllSelectedOptions();
        return selectedColorElement.stream().map(e->e.getText()).collect(Collectors.toList());
    }



    //Size Dropdown actions
    public void selectFromSizeDropdown(String option) {
        findSizeElement().selectByVisibleText(option);
    }

    public List <String> getSelectedSizes() {
        List <WebElement> selectedSizeElement =
                findSizeElement().getAllSelectedOptions();
        return selectedSizeElement.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findSizeElement() {
        return new Select(driver.findElement(sizeDropdown));
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickCartIcon() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
