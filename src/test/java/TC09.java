import Common.AccountRandom;
import Constant.Constant;
import Railway.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {

    @Test(description = "User can't change password when New Password and Confirm Password are different.")
    public void changePasswordTC09() {
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        ChangePasswordPage changepass = new ChangePasswordPage();
        AccountRandom accountRandom = new AccountRandom();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        login.gotoLoginPage();
        login.Login(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Click on Change Password tab");
        changepass.gotoChangePassword();
        changepass.changePassword("123456789", "1234567890", "1234567890");

        String actualMsg = changepass.getErrorMessage();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
    }
}
