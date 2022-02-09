import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC02 extends BaseTest {
    @Test(description = "TC02 - User can not login  login with blank Username textbox")
    public void LoginTC02() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Login tab");
        loginPage.gotoLoginPage();
        System.out.println("3. User doesn't type any words into Username textbox but enter valid information into Password textbox ");
        loginPage.Login("", Constant.PASSWORD);

        String msgErrorLogin = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(msgErrorLogin, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
