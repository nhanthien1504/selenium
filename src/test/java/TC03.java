import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class TC03 extends BaseTest {
    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void LoginTC03(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Login tab");
        loginPage.gotoLoginPage();
        System.out.println("3. Enter valid Email and invalid Password ");
        loginPage.Login(Constant.USENAME, "");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
