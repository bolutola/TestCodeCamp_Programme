package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("boluwatifemotolani@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("adebayo@95");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);
        if(driver.getCurrentUrl().contains("https://www.facebook.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(5000);
    }
    @Test
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div")).click();
        if(driver.getCurrentUrl().contains("https://www.facebook.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(5000);
    }
    @AfterTest
    public void tearDown(){driver.quit();}
}

