package org.example;

import org.example.Assertion.AssertionMainPage;
import org.example.Assertion.AssertionRegister;
import org.example.Assertion.AssertionLogin;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    AssertionLogin assertionLogin = new AssertionLogin();
    AssertionRegister assertionRegister = new AssertionRegister();
    AssertionMainPage assertionMainPage = new AssertionMainPage();

    @Test(priority = 1)
    public void userCanRegisterNewAccount(){
        MobileUtil.click("//*[contains(@resource-id,'textViewLinkRegister')]");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextName')]", "desti");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextEmail')]", "desti@automation.com");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextPassword')]", "12345");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextConfirmPassword')]","12345");
        MobileUtil.click("//*[contains(@resource-id,'appCompatButtonRegister')]");
        assertionRegister.assertRegisterSuccessful();
    }

    @Test(priority = 2)
    public void userWantBackToLoginPageAfterRegister(){
        if (this.individualRun){
            userCanRegisterNewAccount();
        }
        MobileUtil.back();
        assertionLogin.assertLoginPage();
    }

    @Test(priority = 3)
    public void userIsNotAbleToLoginWithBlankEmail(){
        if (this.individualRun){
            userWantBackToLoginPageAfterRegister();
        }
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonLogin')]");
        assertionLogin.assertInvalidEmailOrPassword();
    }

    @Test(priority = 4)
    public void userIsNotAbleToLoginWithBlankPassword(){
        if (this.individualRun){
            assertionLogin.assertLoginPage();
        }
        MobileUtil.click("//*[contains(@resource-id,'textInputEditTextEmail')]");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextEmail')]", "desti@automation.com");
        MobileUtil.click("//*[contains(@resource-id,'appCompatButtonLogin')]");
        assertionLogin.assertInvalidEmailOrPassword();
    }

    @Test(priority = 5)
    public void userIsNotAbleToLoginInvalidCredential(){
        if (this.individualRun){
            assertionLogin.assertLoginPage();
        }
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextPassword')]", "foobar");
        MobileUtil.click("//*[contains(@resource-id,'appCompatButtonLogin')]");
        assertionLogin.assertInvalidCredential();
    }

    @Test(priority =6)
    public void userValidatePasswordMasked(){
        if (this.individualRun){
            MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextEmail')]", "desti@automation.com");
            MobileUtil.click("//*[contains(@resource-id, 'textInputEditTextPassword')]");
        }
        MobileUtil.clearText("//*[contains(@resource-id, 'textInputEditTextPassword')]");
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextPassword')]", "12345");
        MobileUtil.verifyFieldMasked("//*[contains(@resource-id, 'textInputEditTextPassword')]");
    }

    @Test(priority = 7)
    public void userCanLoginWithValidEmailAndPassword() {
        if (this.individualRun){
            MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextEmail')]", "desti@automation.com");
            MobileUtil.click("//*[contains(@resource-id, 'textInputEditTextPassword')]");
            MobileUtil.clearText("//*[contains(@resource-id, 'textInputEditTextPassword')]");
            MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextPassword')]", "12345");
        }
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonLogin')]");
        assertionMainPage.assertDashboard("desti", "12345", "desti@automation.com");
    }

}
