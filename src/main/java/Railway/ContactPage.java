package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //locator
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href ='/Page/Contact.cshtml']");


    //Elements
    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    //Methods
    public void gotoContact(){
        this.getTabContact().click();
    }
}
