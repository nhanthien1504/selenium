import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Railway.*;
import com.google.gson.JsonObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FinalTest01 extends BaseTest{
    @Test(description = "User can book 1 ticket at a time", dataProvider = "data-provider")
    public void BookTicketFN01(String departStation, String arriveStation, String seatType, String ticketAmount){

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();

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
        System.out.println("3. Click on Book ticket tab");

        bookticketPage.gotoBookTickPage();

        System.out.println("5. Select Huế for Depart from and Quảng Ngãi for Arrive at");
        bookticketPage.getDepartDate(bookticketPage.getDay(7));
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(arriveStation);
        System.out.println("6. 6. Select Soft bed with air conditioner for Seat type ");
        bookticketPage.getSeatType(seatType);
        System.out.println("7. Select 3 for Ticket amount");
        bookticketPage.getTicketAmount(ticketAmount);
        System.out.println("8. Click on Book ticket button");
        bookticketPage.getBtnSubmitBookTicket();



        String actualMsg = bookticketPage.getLblMessBookSuccess();
        String expectedMsg = "Ticket Booked Successfully!";



        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");


    }
    @DataProvider (name = "data-provider")
    public Object[][] dataProvider(){
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
