package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    //Selector
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href = '/Account/Register.cshtml']");
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirm = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//*[@id='RegisterForm']/fieldset/p/input");
    private final By lblRegisterSuccess = By.xpath("//div[@id='content']//p[text()='Registration Confirmed! You can now log in to the site.']");
    private final By lblRegisterAccountUsed = By.xpath("//div[@id = 'content']//p[@class='message error']");
    private final By lblPasswordErrMsg = By.xpath("//li/label[@for='password']/following-sibling::label");
    private final By lblPIDErrMsg = By.xpath("//li/label[@for='pid']/following-sibling::label");
    //elements

    protected WebElement getLblPasswordErrMsg() {
        return Constant.WEBDRIVER.findElement(this.lblPasswordErrMsg);
    }

    protected WebElement getLblPIDErrMsg() {
        return Constant.WEBDRIVER.findElement(this.lblPIDErrMsg);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getTxtConfirm() {
        return Constant.WEBDRIVER.findElement(txtConfirm);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    protected WebElement getLblRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccess);
    }

    protected WebElement getLblRegisterAccountUsed() {
        return Constant.WEBDRIVER.findElement(lblRegisterAccountUsed);
    }

    //methods

    public String getSuccessMessage() {
        return this.getLblRegisterSuccess().getText();
    }

    public String getMgsRegisterAccountUsed() {
        return this.getLblRegisterAccountUsed().getText();
    }

    public String getPasswordErrMsg() {
        return this.getLblPasswordErrMsg().getText();
    }

    public String getPIDErrMsg() {
        return this.getLblPIDErrMsg().getText();
    }

    public void gotoRegister() {
        this.getTabRegister().click();
    }

    public void register(String name, String password, String confirm, String pid) {
        try{
            this.getTxtEmail().sendKeys(name);
            this.getTxtPassword().sendKeys(password);
            this.getTxtConfirm().sendKeys(confirm);
            this.getTxtPid().sendKeys(pid);
            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 3000);
            JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
            js.executeScript("arguments[0].scrollIntoView();",  getBtnRegister());
            wait.until(ExpectedConditions.elementToBeClickable(getBtnRegister())).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public String getMgsRegisterSuccess() {
        return this.getLblRegisterSuccess().getText();
    }

}
