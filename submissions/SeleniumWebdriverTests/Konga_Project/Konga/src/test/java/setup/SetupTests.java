package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

public class SetupTests {

    private WebDriver driver;
    public HomePage homePage;

    //Initialize WebDriver, open the browser and go to the URL before conducting the test

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //Initializing WebDriver
        driver = new ChromeDriver();

        //Maximize the web browser
        driver.manage().window().maximize();

        //Open URL on browser
        driver.get("https://www.konga.com/");
        homePage = new HomePage(driver);

    }

    //Quit browser and WebDriver after completing the test

    @AfterTest
    public void quitBrowser()
    {
        driver.quit();
    }

}
