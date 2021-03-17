package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private WebDriver driver;

    private By welcomeAdmin = By.cssSelector("#branding a:nth-child(2)");
    private By logout = By.linkText("Logout");

    public void clickWelcomeAdmin() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(welcomeAdmin).click();
    }

    public LoginPage clickLogout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }


}
