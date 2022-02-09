import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {
    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC016(String departStation, String arriveStation, String seatType, String ticketAmount) {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        AccountRandom accountRandom = new AccountRandom();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.register(accountRandom.createEmail(),
                accountRandom.createPassword(),
                accountRandom.createConfirm(),
                accountRandom.createPid());
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.Login(accountRandom.email, accountRandom.strPassword);

        System.out.println("3. Book a ticket.");
        bookticketPage.gotoBookTickPage();
        bookticketPage.getDepartDate(bookticketPage.getDay(7));
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount);
        bookticketPage.getBtnSubmitBookTicket();

        System.out.println("4. Click on 'My ticket' tab");
        myTicketPage.gotoBookTickPage();

        System.out.println("5. Cancel a ticket");
        myTicketPage.getCancel("1", departStation, arriveStation);

        Assert.assertFalse(myTicketPage.isCancelDisplay("1", departStation, arriveStation), "");

        System.out.println("Test Case ran.");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC16.get("Depart from").getAsString();
        String arriveStation = dataTC16.get("Arrive at").getAsString();
        String seatType = dataTC16.get("Seat type").getAsString();
        String ticketAmount = dataTC16.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
