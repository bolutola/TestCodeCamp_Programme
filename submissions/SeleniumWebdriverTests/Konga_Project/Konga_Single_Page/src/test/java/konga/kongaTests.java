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

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button"));

        if(driver.getCurrentUrl().contains("https://www.konga.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //Wait and pause period
        Thread.sleep(5000);
    }


    //Click on All categories, then computers and accessories, and then Macbooks
    @Test
    public void categorySelect() throws InterruptedException {
        driver.findElement(By.linkText("All Categories")).click();
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/div[1]/div/div/div[1]/ul/li[1]"));
        driver.findElement(By.linkText("Macbooks")).click();

        //Wait and pause period
        Thread.sleep(5000);
    }

    //Click item to add to cart
    @Test
    public void addToCart() throws InterruptedException {
        try {
            WebElement addToCart = driver.findElement(By.cssSelector("#mainContent > section._8d917_1ixfS > section > section > section._588b5_3MtNs > section > ul > li:nth-child(1) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D > button"));
            addToCart.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex)
        {
            System.out.println("element becomes state");
            WebElement addToCart = driver.findElement(By.cssSelector("#mainContent > section._8d917_1ixfS > section > section > section._588b5_3MtNs > section > ul > li:nth-child(1) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D > button"));
            addToCart.click();
        }
        Thread.sleep(5000);

        //Click on My cart menu to view Cart Overview
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]"));
    }

    //Click on CheckOut


    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
