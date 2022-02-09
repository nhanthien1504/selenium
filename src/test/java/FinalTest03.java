import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FinalTest03 extends BaseTest{

    @Test(description = "Error displays when user applies filter with un-existed value of Status in Manage ticket table ", dataProvider = "data-provider")
    public void BookTicketFN03(String departStation, String arriveStation, String seatType, String ticketAmount) {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account ");
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
        System.out.println("3. Book more than 6 tickets ");
        bookticketPage.gotoBookTickPage();
        bookticketPage.getDepartDate(bookticketPage.getDay(7));
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount);
        bookticketPage.getBtnSubmitBookTicket();
        System.out.println("4. Click on My ticket tab ");
        myTicketPage.gotoMyTicket();
        String actualMsg = bookticketPage.getLblMessBookSuccess();
        String expectedMsg = "Ticket Booked Successfully!";


        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");


    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataFinalTest01 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataFinalTest01.get("Depart from").getAsString();
        String arriveStation = dataFinalTest01.get("Arrive at").getAsString();
        String seatType = dataFinalTest01.get("Seat type").getAsString();
        String ticketAmount = dataFinalTest01.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };

        return object;
    }
}
