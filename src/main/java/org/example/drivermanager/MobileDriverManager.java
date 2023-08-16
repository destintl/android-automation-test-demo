package org.example.drivermanager;

import io.appium.java_client.AppiumDriver;
import org.example.DriverManager;

public class MobileDriverManager implements DriverManager {
    private MobileDriverFactory mobileDriverFactory;

    public MobileDriverManager(){
        this.mobileDriverFactory = new MobileDriverFactory();
    }

    @Override
    public AppiumDriver getDriver() {
        AppiumDriver appiumDriver = null;
        System.out.println("Starting application..");
        try {
            appiumDriver = mobileDriverFactory.getAppiumDriver();
        } catch (Exception e) {
            System.out.println("[getDriver_Exception] - " + e.getMessage());
            e.printStackTrace();
        }
        return appiumDriver;
    }

    @Override
    public void destroyDriver(AppiumDriver driver) {
        if (driver != null){
            driver.quit();
        }else{
            System.out.println("Appium is not initialized yet");
        }
    }
}
