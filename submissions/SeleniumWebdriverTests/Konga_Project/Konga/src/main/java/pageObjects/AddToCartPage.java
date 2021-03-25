package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private WebDriver driver;
    private By totalItemCount = By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div/div[1]");
    private By addItem = By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[2]/div/div[1]/div[2]/form/div/div/button[2]");
    private By checkOutButton = By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div/div[6]/div/a");

    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Check the number of items in the cart
    public void itemCount(int count) throws InterruptedException {
        //Convert value showing quantity of an item from String to integer and store in itemNumber variable
        int itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());

        //Compare the current quantity of an item with the expected quantity an increment until they are equal
        while (itemNumber != count)
        {
            //Click the + button to increase the number of the selected item
            driver.findElement(addItem).click();

            //update the value of the quantity in the variable after the increment
            itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());
        }

        //Wait for the check out button to load
        Thread.sleep(5000);
    }

    //Click on the check out button
    public CheckOutPage clickCheckOut() throws InterruptedException {
        driver.findElement(checkOutButton).click();
        //Wait for the checkout page to loa
        Thread.sleep(7000);
        return new CheckOutPage(driver);
    }
}
