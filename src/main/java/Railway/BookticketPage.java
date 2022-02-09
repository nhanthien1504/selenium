package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class BookticketPage extends GeneralPage {

    //Locator
    private final By lblTicket = By.xpath("//div[@id='page']/div[@id='content']/h1[@align='center']");
    private final By cboDepartDate = By.xpath("//div[@id='content']/div/form//select[@name ='Date']");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblMessageBookSuccess = By.xpath("//div[@id='content']/h1");
    private final By lblErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblAmountErrMsg = By.xpath("//label[@class='validation-error']");

    //Dynamic Locator
    String dblDepartFrom = "//select[@name ='DepartStation']//option[text()='%s']";
    String dblArriveAt = "//select[@name ='ArriveStation']//option[text()='%s']";
    String dblSeatType = "//select[@name ='SeatType']//option[text()='%s']";
    String dblTicketAmount = "//select[@name='TicketAmount']//option[text()='%s']";
    String dblDepartDate = "//div[@id='content']/div/form//select[@name ='Date']//option[text()='%s']";
    String value = "//select[@name ='DepartStation']//option[@value='%d']";
    //Element

    protected WebElement get6ticket(int depart) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(value, depart)));
    }

    protected WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }

    protected WebElement getLblAmountErrMsg() {
        return Constant.WEBDRIVER.findElement(lblAmountErrMsg);
    }

    protected WebElement getDblDepartDate(String departDate) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartDate, departDate)));
    }

    protected WebElement getDblTicketAmount(String ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblTicketAmount, ticketAmount)));
    }

    protected WebElement getDblArriveAt(String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblArriveAt, arriveAt)));
    }

    protected WebElement getDblDepartFrom(String departFrom) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartFrom, departFrom)));
    }

    protected WebElement getDblSeatType(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblSeatType, seatType)));
    }


    protected WebElement getlblMessBookSuccess() {
        return Constant.WEBDRIVER.findElement(lblMessageBookSuccess);
    }

    protected WebElement getbtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }


    protected WebElement getCboDepartDate() {
        return Constant.WEBDRIVER.findElement(cboDepartDate);
    }

    protected WebElement getLblTitleTicket() {
        return Constant.WEBDRIVER.findElement(lblTicket);
    }

    //Methods
    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }

    public String getAmountErrMsg() {
        return this.getLblAmountErrMsg().getText();
    }

    public String getLblMessBookSuccess() {
        return this.getlblMessBookSuccess().getText();
    }

    public void getBtnSubmitBookTicket() {
        try {
            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 5000);
            JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
            js.executeScript("arguments[0].scrollIntoView();", getbtnBookTicket());
            wait.until(ExpectedConditions.elementToBeClickable(getbtnBookTicket())).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String getTitleTicketText() {
        return this.getLblTitleTicket().getText();
    }

    public void getDepartDate(String day) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        try {
            this.getDblDepartDate(day).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDay(int day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, day);
        String time = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
        //'01/13/2022'
        if (time.charAt(0) == '0') {
            time = time.substring(1);
        }
        return time;
    }


    public void getDepartFrom(String departFrom) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblDepartFrom(departFrom).click();

    }

    public void getArriveAt(String arrivalAt) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblArriveAt(arrivalAt).click();
    }

    public void getSeatType(String seatType) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblSeatType(seatType).click();
    }

    public void getTicketAmount(String ticketAmount) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblTicketAmount(ticketAmount).click();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }

    public void getBook6Ticket(String arriveAt, String ticketAmount) {
        try {
            for (int j = 1; j < 6; j++) {
                String value = "//select[@name ='DepartStation']//option[@value='%d']";
                WebElement get6ticket = Constant.WEBDRIVER.findElement(By.xpath(String.format(value, j)));
                get6ticket.click();
                getDepartDate(getDay(7));
                WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 50000);
                wait.until(ExpectedConditions.elementToBeClickable(getDblArriveAt(arriveAt)));
                getDblArriveAt(arriveAt);
                getTicketAmount(ticketAmount);
                getBtnSubmitBookTicket();
                gotoBookTickPage();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Constant.WEBDRIVER.navigate().back();
        }

    }
}


