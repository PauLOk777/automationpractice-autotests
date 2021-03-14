package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

    private static final String HREF = "href";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLinkForAccount(String userName) {
        return getDriver().findElement(By.linkText(userName)).getAttribute(HREF);
    }

    public void waitUntilPageIsAvailable() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.id("newsletter-input")));
    }
}
