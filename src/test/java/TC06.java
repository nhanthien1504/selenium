import Constant.Constant;
import Railway.ContactPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC06 extends BaseTest {

    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void LogoutTC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        LogoutPage logoutPage = new LogoutPage();
        ContactPage contactPage = new ContactPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with valid Email and Password");
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Click on Contact tab");
        contactPage.gotoContact();
        System.out.println("4. Click on Log out tab");
        logoutPage.goToLogoutPage();

        Boolean actualMsg = loginPage.isGoToLogoutPage();

        Assert.assertFalse(actualMsg,"Logout tab not is display in menu");
        Assert.assertTrue(actualMsg,"The logout tab to is display in the menu");

        //compare conditions
        System.out.println("Test Case Run");
    }

}
