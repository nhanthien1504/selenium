package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class TimetablePage extends GeneralPage {
    //selector
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href ='TrainTimeListPage.cshtml']");
    private final By lblMessage = By.xpath("//tr[@class='TableSmallHeader']");
    //Dynamic Locator
    String dblRow = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";
    //element
    protected WebElement getDblrow(String departStation, String ArriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblRow, departStation, ArriveStation)));
    }

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getlblMessage() {
        return Constant.WEBDRIVER.findElement(lblMessage);
    }

    //methods
    public void getDblRow(String depart, String arrive) {
        try {
            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 3000);
            wait.until(ExpectedConditions.visibilityOf(getDblrow(depart, arrive)));
            new Actions(Constant.WEBDRIVER).moveToElement(this.getDblrow(depart, arrive)).click().perform();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLblMessage() {
        return this.getlblMessage().getText();
    }

    public void gotoTabTimeTable() {
        this.getTabTimetable().click();
    }

}
