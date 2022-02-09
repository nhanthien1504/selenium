package Railway;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountRandom {
    List<String> password = new ArrayList<>();
    List<String> email = new ArrayList<>();




    //Create Email random
    public String createEmail() {
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        email.add(generatedString);
        return generatedString + "@gmail.com";
    }


    //Create Password random
    public String createPassword() {
        String strPassword = RandomStringUtils.randomAscii(9);
        password.add(strPassword);
        strPassword = password.toString();
        strPassword = strPassword.substring(1, strPassword.length() - 1);
        return strPassword;
    }


    public String createConfirmSucess() {
        String strConfirm = password.toString();
        strConfirm = strConfirm.substring(1, strConfirm.length() - 1);
        return strConfirm;
    }

    public String createPid() {
        return RandomStringUtils.randomNumeric(9);
    }

    public String checkConfirm(String strCheck) {
        String strInput = createPassword();
        String note;
        if (strCheck.equals(strInput)) {
            note = strCheck;
        } else {
            note = "doesn't match";
        }
        return note;
    }
}
