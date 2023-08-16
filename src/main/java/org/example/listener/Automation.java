package org.example.listener;

import io.appium.java_client.AppiumDriver;
import org.example.BaseTest;
import org.example.GlobalVariable;
import org.testng.ITestResult;

public class Automation implements BaseListener {
    private boolean isInitiated;

    public Automation(){
        this.isInitiated = false;
    }

    @Override
    public int getPriority() {
        return -100;
    }

    @Override
    public void beforeMethod(BaseTest test) {
        System.out.println("----- Running Automation Before Test -----");
        AppiumDriver appiumDriver;
        try {
            if (test.isIndividualRun()){
                if (this.isInitiated){
                    appiumDriver = test.getDriverManager().getDriver();
                    test.setDriver(appiumDriver);
                }else{
                    appiumDriver = test.getDriver();
                    this.isInitiated = true;
                }
                GlobalVariable.appiumDriver = appiumDriver;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void afterMethod(BaseTest test, ITestResult result) {
        System.out.println("----- Running Automation After Test -----");
        if (result.getStatus() == ITestResult.FAILURE){
            test.setIndividualRun(true);
            if (test.isCloseAfterFinish()){
                test.getDriverManager().destroyDriver(test.getDriver());
            }
        }else{
            test.setIndividualRun(false);
        }

    }
}
