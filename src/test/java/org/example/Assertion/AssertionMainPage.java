package org.example.Assertion;

import org.example.MobileUtil;

public class AssertionMainPage {

    public void assertDashboard(String name, String password, String email){
       MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Android NewLine Learning']",5);
       MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Hello,']",5);
       MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='All Accounts']",10);

        String actualEmail2 = MobileUtil.getText("//*[contains(@resource-id,'textViewName')and @index = '2']");
        MobileUtil.verifyStringMatch(actualEmail2, email);

        //name
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Name']",10);
        String actualName = MobileUtil.getText("//*[contains(@resource-id,'textViewName')and @index = '1']");
        MobileUtil.verifyStringMatch(actualName, name);

        //password
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Password']",10);
        String actualPassword = MobileUtil.getText("//*[contains(@resource-id,'textViewPassword')]");
        MobileUtil.verifyStringMatch(actualPassword, password);

        //email
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Email']",10);
        String actualEmail= MobileUtil.getText("//*[contains(@resource-id,'textViewEmail')]");
        MobileUtil.verifyStringMatch(actualEmail, email);
    }

}
