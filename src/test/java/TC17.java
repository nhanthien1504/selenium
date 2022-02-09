import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import Railway.BookticketPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17  extends BaseTest{
    @Test(description = "TC14(Set3) - User can't book more than 10 tickets", dataProvider = "data-provider")
    public void TC014(String departStation, String arriveStation, String seatType, String ticketAmount10, String ticketAmount1) {
        HomePage homePage = new HomePage();
        BookticketPage bookticketPage = new BookticketPage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();
        LoginPage loginPage = new LoginPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.register(accountRandom.createEmail(),
                accountRandom.createPassword(),
                accountRandom.createConfirm(),
                accountRandom.createPid());
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.Login(accountRandom.email, accountRandom.strPassword);

        System.out.println("3. Click on 'Book ticket' tab");
        bookticketPage.gotoBookTickPage();

        System.out.println("4. Book 10 tickets.");
        bookticketPage.getDepartDate(bookticketPage.getDay(7));
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount10);
        bookticketPage.getBtnSubmitBookTicket();

        System.out.println("5. Click on 'Book ticket' tab again");
        bookticketPage.gotoBookTickPage();

        System.out.println("6. Book one more ticket.");
        bookticketPage.getDepartDate(bookticketPage.getDay(7));
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount1);
        bookticketPage.getBtnSubmitBookTicket();

        String excepMsg1 = "There're errors in the form. Please correct the errors and try again.";
        String actualMsg1 = bookticketPage.getErrorMessage();
        Assert.assertEquals(actualMsg1,excepMsg1,"Error msg is not display as expected");

        String actualMsg2 = "You have booked 10 tickets. You can book no more.";
        String expectedMsg2 = bookticketPage.getAmountErrMsg();
        Assert.assertEquals(actualMsg2, expectedMsg2, "Ticket Amount error msg is not display as expected");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC17.get("Depart from").getAsString();
        String arriveStation = dataTC17.get("Arrive at").getAsString();
        String seatType = dataTC17.get("Seat type").getAsString();
        String ticketAmount10 = dataTC17.get("Ticket amount 10").getAsString();
        String ticketAmount1 = dataTC17.get("Ticket amount 1").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount10, ticketAmount1}
        };
        return object;
    }
}
