package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends Page {

    private static final String SIGN_IN_PAGE_URL =
            "http://automationpractice.com/?controller=authentication&back=my-account";

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "SubmitCreate")
    private WebElement buttonSubmitPreCreate;

    @FindBy(name = "email_create")
    private WebElement inputEmailForPreCreate;

    @FindBy(css = "#login_form input#email")
    private WebElement inputEmailForSignIn;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement inputPasswordForSignIn;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitSignIn;

    @FindBy(css = "div.alert-danger li")
    private WebElement authenticationFailedLi;

    @FindBy(css = "div#create_account_error li")
    private WebElement invalidEmailAddressPreCreateLi;

    public void openSignInPage() {
        getDriver().get(SIGN_IN_PAGE_URL);
    }

    public void submitSignIn() {
        buttonSubmitSignIn.click();
    }

    public void submitPreCreate() {
        buttonSubmitPreCreate.click();
    }

    public void fillEmailForSignIn(String email) {
        inputEmailForSignIn.sendKeys(email);
    }

    public void fillEmailForPreCreate(String email) {
        inputEmailForPreCreate.sendKeys(email);
    }

    public void fillPasswordForSignIn(String password) {
        inputPasswordForSignIn.sendKeys(password);
    }

    public String getAuthenticationFailedMessage() {
        return getWait().until(ExpectedConditions.elementToBeClickable(authenticationFailedLi)).getText();
    }

    public String getInvalidEmailAddressPreCreateMessage() {
        return getWait().until(ExpectedConditions.elementToBeClickable(invalidEmailAddressPreCreateLi)).getText();
    }

    public void waitUntilPageIsAvailable() {
        getWait().until(ExpectedConditions.elementToBeClickable(buttonSubmitPreCreate));
    }
}
