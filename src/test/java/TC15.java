import Common.AccountRandom;
import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.RegisterPage;
import Railway.TimetablePage;
import com.google.gson.JsonObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC15 extends BaseTest {

    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page",
            dataProvider = "data-provider")
    public void ticketPriceTC15(String departStation, String arriveStation){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();

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
        System.out.println("3. Click on Timetable tab");
        timetablePage.gotoTabTimeTable();
        System.out.println("4. Click on check price link of the route from Đà Nẵng to Sài Gòn");
        timetablePage.getDblRow(departStation,arriveStation);



    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC15.get("Depart Station").getAsString();
        String arriveStation = dataTC15.get("Arrive Station").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation}
        };
        return object;
    }
}

