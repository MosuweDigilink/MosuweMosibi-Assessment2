package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath(
            "//button[normalize-space() = 'Log in']");

    private By cartButton = By.xpath("//span[@class = 'cart-name-and-total']");

    private By errorCaption = By.tagName("strong");

    private By logoutButton = By.linkText("Logout");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashBoardPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new DashBoardPage(driver);
    }

    public String getErrorText() {
        return driver.findElement(errorCaption).getText();
    }

    public DashBoardPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new DashBoardPage(driver);
    }
}
