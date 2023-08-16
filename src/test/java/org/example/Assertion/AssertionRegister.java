package org.example.Assertion;

import org.example.MobileUtil;

public class AssertionRegister {

    public void assertRegisterPage(){
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextName')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextEmail')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextPassword')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextConfirmPassword')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'appCompatButtonRegister')]");
    }

    public void assertNameErrorMessage(){
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Enter Full Name']");
    }

    public void assertEmailErrorMessage(){
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Enter Valid Email']");
    }
    public void assertPasswordErrorMessage(){
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Enter Password']");
    }
    public void assertConfirmPasswordErrorMessage(){
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Password Does Not Matches']");
    }

    public void assertRegisterSuccessful(){
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'snackbar_text') and @text='Registration Successful']");
    }

    public void assertEmailAlreadyExists(){
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'snackbar_text') and @text='Email Already Exists']");
    }

}
