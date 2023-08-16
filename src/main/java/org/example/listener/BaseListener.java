package org.example.listener;

import org.example.BaseTest;
import org.testng.ITestResult;

public interface BaseListener {
    int getPriority();
    void beforeMethod(BaseTest test);
    void afterMethod(BaseTest test, ITestResult result);
}
