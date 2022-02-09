import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01 extends BaseTest {

    @Test(description = "TC01 - User can login into Railway with valid username and password")
    public void LoginTC01() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Login tab");
        loginPage.gotoLoginPage();
        System.out.println("3. Enter valid Email and Password");
        loginPage.Login("100nhanthien@gmail.com", "123456789");

        String actualMsg = loginPage.getWelcomeMesage();
        String expectedMsg = "Welcome " + Constant.USENAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
