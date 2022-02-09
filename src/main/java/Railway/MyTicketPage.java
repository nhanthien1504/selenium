package Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTicketPage extends GeneralPage {
    //locator
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";
    private final By tabMyticket = By.xpath("//div[@id='menu']//a[@href ='/Page/ManageTicket.cshtml']");


    //element
    protected WebElement getBtnCancel(String id, String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(this.btnCancel, id, departStation, arriveStation)));
    }

    protected WebElement getTabMyticket(){
        return Constant.WEBDRIVER.findElement(tabMyticket);
    }

    //method
    public void gotoMyTicket()
    {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 50000);
        wait.until(ExpectedConditions.elementToBeClickable(getTabMyticket()));
        this.getTabMyticket().click();
    }

    public void getCancel(String id, String departStation, String arriveStation) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(this.getBtnCancel(id, departStation, arriveStation))).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isCancelDisplay(String id, String departStation, String arriveStation) {
        try {
            return this.getBtnCancel(id, departStation, arriveStation).isDisplayed();
        } catch (Exception var5) {
            System.out.print(var5.getMessage());
            return false;
        }
    }
}
