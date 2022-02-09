import Constant.Constant;
import Common.AccountRandom;
import Railway.HomePage;
import Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends BaseTest {

    @Test(description = "User can't create account with an already in-use email")
    public void RegisterTC10() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Register tab");
        registerPage.gotoRegister();
        registerPage.register(Constant.USENAME,
                Constant.PASSWORD,
                Constant.PASSWORD,
                accountRandom.createPid());

        String actualMsg = registerPage.getMgsRegisterAccountUsed();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");


    }
}
