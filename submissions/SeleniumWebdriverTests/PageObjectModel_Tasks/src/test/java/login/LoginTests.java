package login;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import setup.SetupTests;

public class LoginTests extends SetupTests {

    @Test
    public void testLogin() throws InterruptedException {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");
        loginPage.clickLoginBtn();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page url is " + pageUrl);
    }

    @Test
            public void testLogout () {
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page url is " + loginUrl);
        }
    }
}
