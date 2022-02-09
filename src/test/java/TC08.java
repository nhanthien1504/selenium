import Common.AccountRandom;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "User can't login with an account hasn't been activated")
    public void LoginTC08() {
        HomePage home = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        AccountRandom accountRandom = new AccountRandom();
        System.out.println("1. Navigate to QA Railway Website");
        home.open();
        System.out.println("2. Click on Login tab");
        registerPage.gotoRegister();
        registerPage.register(
                accountRandom.createEmail(),
                accountRandom.createPassword(),
                accountRandom.createConfirm()
                ,accountRandom.createPid());

        String actualMsg = registerPage.getMgsRegisterAccountUsed();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
    }
}
