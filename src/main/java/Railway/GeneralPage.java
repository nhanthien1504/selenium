package Railway;

import Constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class GeneralPage {
    //locator
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href = '/Account/Login.cshtml']");
    private final By tabBooktick = By.xpath("//div[@id='menu']//a[@href ='/Page/BookTicketPage.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href = '/Account/Logout']");
    private final By lblWelcomeMesage = By.xpath("//div[@class='account']/strong");
    private final By lblLogout = By.xpath("//div[@id='menu']//a/span[text()='Log out']");

    //Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {

        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMesage() {

        return Constant.WEBDRIVER.findElement(lblWelcomeMesage);
    }

    protected WebElement getTabBooktick() {
        return Constant.WEBDRIVER.findElement(tabBooktick);
    }

    protected WebElement getLblLogout() {return Constant.WEBDRIVER.findElement(lblLogout);}

    //Method

    public String getWelcomeMesage() {
        return this.getLblWelcomeMesage().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public boolean isGoToLogoutPage(){
        try{
            if (getLblLogout().isDisplayed())
            {
                return false;
            }else{
                return true;
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return false;
    }

    public void gotoBookTickPage() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getTabBooktick().click();

    }

    public void goToLogoutPage(){
        this.getTabLogout().click();
    }

}