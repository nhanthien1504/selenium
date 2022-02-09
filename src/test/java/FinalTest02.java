import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FinalTest02 extends BaseTest{
    @Test(description = "User can filter Manage ticket table with Depart Station", dataProvider = "data-provider")
    public void BookTicketFN02(String arriveStation, String ticketAmount){

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
        System.out.println("3. Book more than 6 tickets with different Depart Stations ");
        bookticketPage.gotoBookTickPage();
        bookticketPage.getBook6Ticket(arriveStation, ticketAmount);
        System.out.println("4. Click on My ticket tab ");
        myTicketPage.gotoMyTicket();
        String actualMsg = bookticketPage.getLblMessBookSuccess();
        String expectedMsg = "Ticket Booked Successfully!";



        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");


    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataFinalTest02 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String arriveStation = dataFinalTest02.get("Arrive at").getAsString();
        String ticketAmount = dataFinalTest02.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {arriveStation,ticketAmount}
        };

        return object;
    }
}
