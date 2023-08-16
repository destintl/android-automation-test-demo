package org.example;

import io.appium.java_client.AppiumDriver;

public interface DriverManager {
    AppiumDriver getDriver();
    void destroyDriver(AppiumDriver driver);
}
