package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Localtor
    private final By tabHome = By.xpath("//div[@id='menu']//li[@class = 'selected']//a[@href='../']");
    private final By lblWelcomeHone =By.xpath("//div[@id='content']//h1[@align= 'center']");
    //Elements
    protected WebElement getTabHome(){
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getLblWelcomeHone(){
        return Constant.WEBDRIVER.findElement(lblWelcomeHone);
    }
    //Methods

    public void getWelcomeHone(){
        this.getLblWelcomeHone().getText();
    }

    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public void gotoHomepage(){
        this.getTabHome().click();
    }

}
