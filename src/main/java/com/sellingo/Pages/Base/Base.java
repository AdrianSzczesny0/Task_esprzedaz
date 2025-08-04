package com.sellingo.Pages.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String value) {
        type(locator, value, 10);
    }

    protected void type(By locator, String value, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        element.clear();
        element.sendKeys(value);
    }

    protected void click(By locator) {
        click(locator, 10);
    }

    protected void click(By locator, int timeoutInSeconds) {
        WebElement element = waitForElementClickable(locator, timeoutInSeconds);
        element.click();
    }
    protected void clickParent(By locator) {
        WebElement child = waitForElementVisible(locator,10);
        WebElement parent = child.findElement(By.xpath(".."));
        parent.click();
    }
    protected void select(By locator, String visibleText, int timeoutInSeconds) {
        WebElement dropdown = waitForElementVisible(locator, timeoutInSeconds);
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    protected String getText(By locator, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        String text = element.getText();
        return text;
    }
    protected String getText(By locator) {
        WebElement element = waitForElementVisible(locator,10);
        String text = element.getText();
        return text;
    }
    protected String getInputValue(By locator) {
        WebElement element = waitForElementVisible(locator, 10);
        return element.getAttribute("value");
    }

    protected boolean isVisible(By locator) {
        try {
            boolean result = waitForElementVisible(locator, 10).isDisplayed();
            return result;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isVisible(By locator, int timeoutInSeconds) {
        try {
            boolean result = waitForElementVisible(locator, timeoutInSeconds).isDisplayed();
            return result;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected String getWebElementText(By locator, int timeoutInSeconds) {
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        return element.getText();
    }
    protected void assertPageTitle(String expectedTitle, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        boolean titleIsCorrect = wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertTrue(titleIsCorrect, "Expected page title: " + expectedTitle +
                " but found: " + driver.getTitle());
    }
}