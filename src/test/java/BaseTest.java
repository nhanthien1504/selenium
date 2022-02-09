import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {

    @BeforeTest
    public void InitTest(){
        System.out.println("Start Testing");
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        System.out.println("reset method");

    }

//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
//        System.out.println("End Method");
//    }
//
//
//    @AfterTest
//    public void closeTest(){
//        System.out.println("End Test");
//    }
}
