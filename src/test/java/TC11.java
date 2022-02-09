import Common.AccountRandom;
import Railway.HomePage;
import Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 {
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC011() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on 'Register' tab");
        registerPage.gotoRegister();
        System.out.println("3. Register new account with valid email leave other fields empty");
        registerPage.register(accountRandom.createEmail(), "", "", "");
        String actualMsg1 = registerPage.getMgsRegisterAccountUsed();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error msg is not display as expected");
        String actualMsg2 = registerPage.getPasswordErrMsg();
        String expectedMsg2 = "Invalid password length.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "'Password' field error msg is not display as expected");
        String actualMsg3 = registerPage.getPIDErrMsg();
        String expectedMsg3 = "Invalid ID length.";
        Assert.assertEquals(actualMsg3, expectedMsg3, "'PID' field error msg is not display as expected");
        System.out.println("Test Case ran.");
    }
}
