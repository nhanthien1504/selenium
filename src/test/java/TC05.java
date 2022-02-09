import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.plugin.com.BeanCustomizer;

import javax.xml.ws.Holder;

public class TC05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void LoginTC05() {
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Login tab");
        login.gotoLoginPage();
        System.out.println("3. Enter valid information into Username textbox except Password textbox.");
        login.LoginMutilTime("", "", 4);
        System.out.println("5. Repeat step 3 three more times.");
        String actualMsg = login.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        //compare conditions
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");

    }

}

