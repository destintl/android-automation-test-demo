package org.example.drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverManager {
    static AppiumDriver driver;

    public static void main(String[] args) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 API 30");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
            desiredCapabilities.setCapability("appPackage","com.loginmodule.learning");
            desiredCapabilities.setCapability("appActivity", "com.loginmodule.learning.activities.LoginActivity");

            URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(appiumServer, desiredCapabilities);
            System.out.println("Application Started...");
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
