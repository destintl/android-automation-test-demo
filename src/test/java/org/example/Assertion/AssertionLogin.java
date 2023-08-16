package org.example.Assertion;

import org.example.MobileUtil;

public class AssetionLogin {
    public void assetLoginPage() {
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextEmail')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textInputEditTextPassword')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'appCompatButtonLogin')]");
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'textViewLinkRegister')]");
    }

    public void assertInvalidEmailOrPassword(){
        MobileUtil.verifyElementVisible("//*[contains(@class, 'android.widget.TextView') and @text='Enter Valid Email']");
    }

    public void assertInvalidCredential(){
        MobileUtil.verifyElementVisible("//*[contains(@resource-id, 'snackbar_text') and @text='Wrong Email or Password']");
    }
}
