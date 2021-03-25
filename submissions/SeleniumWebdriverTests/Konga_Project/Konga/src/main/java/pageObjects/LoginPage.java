package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.id("username");
    private By userPassword = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Enter username
    public void enterUsername(String hostName)
    {
        driver.findElement(userName).sendKeys(hostName);
    }

    //Enter password
    public void enterPassword(String hostPassword)
    {
        driver.findElement(userPassword).sendKeys(hostPassword);
    }

    //Click on the login button
    public HomePage clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new HomePage(driver);
    }
}


