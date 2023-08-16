package org.example;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.drivermanager.MobileDriverManager;
import org.example.listener.Automation;
import org.example.listener.BaseListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

@Getter
@Setter
public abstract class BaseTest {
    protected DriverManager driverManager;
    protected ThreadLocal<AppiumDriver> driver;
    protected boolean individualRun;
    protected boolean closeAfterFinish;
    protected ArrayList<BaseListener> listeners;

    public BaseTest(){
        try {
            this.driverManager = new MobileDriverManager();
            this.listeners = new ArrayList<>();
            this.listeners.add(new Automation());
            this.driver = new ThreadLocal<>();
            AppiumDriver initilizedDriver = this.driverManager.getDriver();
            this.setDriver(initilizedDriver);
            this.individualRun = true;
            this.closeAfterFinish = true;
            GlobalVariable.appiumDriver = initilizedDriver;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppiumDriver getDriver(){
        return this.driver.get();
    }

    public void setDriver(AppiumDriver driver){
        this.driver.set(driver);
    }

    @SneakyThrows
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("::Before Test Suite::");
        listeners.sort(Comparator.comparingInt(BaseListener::getPriority));
    }

    @SneakyThrows
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method, ITestResult result){
        System.out.println("::Before Test Case::");
        listeners.get(0).beforeMethod(this);
        System.out.println("Start Test Case: " + method.getName());
    }

    @SneakyThrows
    @AfterMethod(alwaysRun = true)
    public void afterTest(Method method, ITestResult result){
        System.out.println("::After Test Case::");
        listeners.get(0).afterMethod(this, result);
        System.out.println("End Test Case: " + method.getName());
    }

    @SneakyThrows
    @AfterSuite(alwaysRun = true)
    public void cleanUp(){
        System.out.println("::After Test Suite::");
        if (this.closeAfterFinish){
            this.driverManager.destroyDriver(this.driver.get());
        }
    }

}
