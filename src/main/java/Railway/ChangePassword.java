package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ChangePassword {

    //Selector
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href = '/Account/ChangePassword.cshtml']");
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//p[@class ='form-actions']//input[@value = 'Change Password']");
    private final By lblChangePasswordError = By.xpath("//p[@class='message error']");

    //elements
    protected WebElement getLblChangePasswordError() {
        return Constant.WEBDRIVER.findElement(lblChangePasswordError);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    //Method
    public void gotoChangePassword() {
        this.getTabChangePassword().click();
    }

    public void changePassword(String currentpassword, String newpassword, String confirmpassword) {
        this.getTxtCurrentPassword().sendKeys(currentpassword);
        this.getTxtNewPassword().sendKeys(newpassword);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getBtnChangePassword().click();
    }

    public String getErrorMessage(){
        return this.getLblChangePasswordError().getText();
    }
}
