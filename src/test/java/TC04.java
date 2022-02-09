import Constant.Constant;
import Railway.BookticketPage;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC04 extends BaseTest {
    @Test(description = "TC04 - User can login into Railway with valid usename and password")
    public void BooktickTC04() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookTicket = new BookticketPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on Book ticket tab");
        bookTicket.gotoBookTickPage();
        System.out.println("3. Login with valid account");
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);



        String actualMsg = bookTicket.getTitleTicketText();
        String expectedMsg = "Book ticket";

        //check if your error message is in the output variable
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
