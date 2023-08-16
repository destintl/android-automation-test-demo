package org.example;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Slf4j
public class MobileUtil {
    private static AppiumDriver appiumDriver = GlobalVariable.appiumDriver;

    public static void click(String xpath){
        boolean isVisible = checkVisibility(xpath, GlobalVariable.wait_page_fast);
        boolean isClickable = checkClickability(xpath, GlobalVariable.wait_page_fast);
        if (isVisible && isClickable){
            WebElement element = appiumDriver.findElement(By.xpath(xpath));
            element.click();
            System.out.println("Element with path " + xpath + " is clicked");
        }else{
            if (!isVisible){
                throw new NoSuchElementException("Element with " + xpath + " is not visible");
            }else{
                throw new IllegalStateException("Element with path " + xpath + " is not clickable");
            }
        }
    }

    public static void back(){
        appiumDriver.navigate().back();
    }

    public static void verifyElementVisible(String xpath){
        verifyElementVisible(xpath, GlobalVariable.wait_page_fast);
    }

    public static void verifyElementVisible(String xpath, int timeout){
        boolean isVisible = checkVisibility(xpath, timeout);
        if (isVisible){
            System.out.println("Element with path " + xpath + " is visible");
        }else{
            throw new TimeoutException("Element with path " + xpath + " is not visible");
        }
    }

    public static String getText(String xpath, int timeout){
        boolean isVisible = checkVisibility(xpath, timeout);
        if(isVisible){
            String text;
            WebElement element = appiumDriver.findElement(By.xpath(xpath));
            text = element.getText();
            System.out.println("Element with path " + xpath + " has text: " + text);
            return text;
        }else{
            throw new NoSuchElementException("Element with path " + xpath + " is not visible");
        }
    }

    public static String getText(String xpath){
        return getText(xpath, GlobalVariable.wait_page_fast);
    }

    public static void clearText(String xpath){
        boolean isVisible = checkVisibility(xpath, GlobalVariable.wait_page_fast);
        if (isVisible){
            WebElement element = appiumDriver.findElement(By.xpath(xpath));
            element.clear();
            System.out.println("Text in element " + xpath + " is clear");
        }else{
            throw new NoSuchElementException("Element with " + xpath + " is not visible");
        }
    }

    public static void setText(String xpath, String text){
        boolean isVisible = checkVisibility(xpath, GlobalVariable.wait_page_fast);
        if (isVisible){
           clearText(xpath);
            WebElement element = appiumDriver.findElement(By.xpath(xpath));
            element.sendKeys(text);
            System.out.println("Text in element " + xpath + " inserted");

        }else{
            throw new NoSuchElementException("Element with " + xpath + " is not visible");
        }
    }

    private static boolean checkVisibility(String xpath, int timeout){
        boolean isVisible = false;
        try {
            By by = By.xpath(xpath);
            new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            isVisible = true;
        } catch (Exception e) {
            System.out.println("[verifyElementVisible_Exception] - " + e.getMessage());
            e.printStackTrace();
        }
        return isVisible;
    }

    private static boolean checkClickability(String xpath, int timeout){
        boolean isClickable = false;
        try {
            By by = By.xpath(xpath);
            new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
            isClickable = true;
        } catch (Exception e) {
            System.out.println("[verifyElementVisible_Exception] - " + e.getMessage());
            e.printStackTrace();
        }
        return isClickable;
    }

    public static void verifyStringMatch(String actualValue, String expectedValue)
            throws AssertionError {
        try {
            Assert.assertTrue(actualValue.matches(expectedValue));
            log.info(
                    String.format(
                            "Text: \"%s\" match with expected text: \"%s\"",
                            actualValue.replaceAll("\n", " "), expectedValue));
        } catch (AssertionError var7) {
            throw new AssertionError(
                    String.format("Text is %s while expected text is %s", actualValue, expectedValue));
        }
    }

    public static void verifyFieldMasked(String xpath){
        WebElement element = appiumDriver.findElement(By.xpath(xpath));
        boolean isMasked =  element.getAttribute("password").equals("true");
       if (isMasked){
           System.out.println("Element with path " + xpath + " is masked field");
       }else {
           throw new TimeoutException("Element with path " + xpath + " is not masked field");
       }
    }

}
