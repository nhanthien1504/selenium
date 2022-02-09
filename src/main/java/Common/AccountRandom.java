package Common;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountRandom {
    public String strPassword;
    public String email;
    public String strConfirm;
    
    //Create Email random
    public String createEmail() {
        email = RandomStringUtils.randomAlphanumeric(8);
        email = email+"@gmail.com";
        return this.email;
    }

    //Create Password random
    public String createPassword() {
        strPassword = RandomStringUtils.randomNumeric(9);
        return this.strPassword;
    }

    public String createConfirm() {
        strConfirm = strPassword;
        return strConfirm;
    }

    public String createPid() {
        return RandomStringUtils.randomNumeric(9);
    }

}
