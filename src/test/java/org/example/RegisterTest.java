package org.example;

import org.example.Assertion.AssertionRegister;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    AssertionRegister assertionRegister = new AssertionRegister();

    @Test(priority = 1)
    public void userIWantToVerifyRegisterPage(){
        if (this.individualRun){
            MobileUtil.click("//*[contains(@resource-id, 'textViewLinkRegister')]");
        }
        assertionRegister.assertRegisterPage();
    }

    @Test(priority = 2)
    public void userVerifyNameIsMandatory(){
        if (this.individualRun){
            userIWantToVerifyRegisterPage();
        }
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        assertionRegister.assertNameErrorMessage();
    }

    @Test(priority = 3)
    public void userVerifyWrongFormatEmail(){
        if (this.individualRun){
            userVerifyNameIsMandatory();
        }
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextName')]", "Natalia");
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextEmail')]", "nata.com");
        assertionRegister.assertEmailErrorMessage();
    }

    @Test(priority = 4)
    public void userVerifyEmailIsMandatory(){
        if (this.individualRun){
            userVerifyWrongFormatEmail();
        }
        MobileUtil.clearText("//*[contains(@resource-id, 'textInputEditTextEmail')]");
        assertionRegister.assertEmailErrorMessage();
    }

    @Test(priority = 5)
    public void userVerifyPasswordIsMandatory(){
        if (this.individualRun){
            userVerifyEmailIsMandatory();
        }
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextEmail')]", "natalia@testing.com");
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        assertionRegister.assertPasswordErrorMessage();
    }

    @Test(priority = 6)
    public void userVerifyPasswordIsMasked(){
        if (this.individualRun){
            userVerifyPasswordIsMandatory();
        }
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextPassword')]", "password");
        MobileUtil.verifyFieldMasked("//*[contains(@resource-id, 'textInputEditTextPassword')]");
    }

    @Test(priority = 7)
    public void userVerifyConfirmPasswordIsMandatory(){
        if (this.individualRun){
            userVerifyPasswordIsMandatory();
            MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextPassword')]", "password");
        }
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        assertionRegister.assertConfirmPasswordErrorMessage();
    }

    @Test(priority = 8)
    public void userVerifyConfirmPasswordIsMasked(){
        if (this.individualRun){
            userVerifyConfirmPasswordIsMandatory();
        }
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextConfirmPassword')]", "password123");
        MobileUtil.verifyFieldMasked("//*[contains(@resource-id, 'textInputEditTextConfirmPassword')]");
    }

    @Test(priority = 9)
    public void userVerifyConfirmPasswordNotMatch(){
        if (this.individualRun){
            userVerifyConfirmPasswordIsMandatory();
            MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextConfirmPassword')]", "password123");
        }
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        assertionRegister.assertConfirmPasswordErrorMessage();
    }

    @Test(priority = 10)
    public void userRegisterAccount(){
        if (this.individualRun){
            userVerifyConfirmPasswordNotMatch();
        }
        MobileUtil.setText("//*[contains(@resource-id, 'textInputEditTextConfirmPassword')]", "password");
        MobileUtil.click("//*[contains(@resource-id, 'appCompatButtonRegister')]");
        assertionRegister.assertRegisterSuccessful();
    }

    @Test(priority = 11)
    public void userVerifyAccountAlreadyExist(){
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextName')]", "desti");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextEmail')]", "natalia@testing.com");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextPassword')]", "12345");
        MobileUtil.setText("//*[contains(@resource-id,'textInputEditTextConfirmPassword')]","12345");
        MobileUtil.click("//*[contains(@resource-id,'appCompatButtonRegister')]");
        assertionRegister.assertEmailAlreadyExists();
    }

}
