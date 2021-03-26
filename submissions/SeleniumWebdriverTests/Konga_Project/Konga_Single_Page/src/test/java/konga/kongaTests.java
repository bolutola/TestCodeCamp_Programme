package konga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class kongaTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.konga.com/");

        Thread.sleep(5000);

        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    //Click on Login and enter Login details
    @Test
    public void loginTest() throws InterruptedException {

        driver.findElement(By.linkText("Login / Signup")).click();

        driver.findElement(By.id("username")).sendKeys("boluwatifemotolani@gmail.com");

        driver.findElement(By.id("password")).sendKeys("adebayo95");

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        Thread.sleep(10000);

        if(driver.getCurrentUrl().contains("https://www.konga.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //Wait and pause period
        Thread.sleep(5000);


    //Click on All categories, then computers and accessories, and then Macbooks

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/nav/div[3]/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/div[1]/div/div/div[1]/ul/li[1]"));
        driver.findElement(By.linkText("Macbooks")).click();

        //Wait and pause period
        Thread.sleep(5000);

    //Click item to add to cart
     driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[11]/div/div/div[2]/form/div[4]/button")).click();
            // "//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[7]/div/div/div[2]/form/div[4]/button")).click();
           Thread.sleep(5000);

        //Click on My cart menu to view Cart Overview
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]")).click();

        //Click on Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //Select address
        driver.findElement(By.linkText("Change Address")).click();
        driver.findElement(By.name("selectDeliveryAddress")).click();
        driver.findElement(By.linkText("Use this Address")).click();

        Thread.sleep(5000);

        //Click on Pay now
        driver.findElement(By.name("selectPaymentMethod")).click();
        Thread.sleep(5000);

        //Click on continue to payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(10000);

        //Switch to iFrame element
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);

        //Click to select card payment type
        By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button").findElement(driver).click();
        //driver.findElement(By.xpath("")).click();
        Thread.sleep(5000);

        //Click to input invalid card details
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("card-number")).sendKeys("5123 4567 8900 0011");
        driver.findElement(By.id("expiry")).sendKeys("10/23");
        driver.findElement(By.id("cvv")).sendKeys("321");
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]")));

        //Click to close checkout modal frame
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
    }



    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
